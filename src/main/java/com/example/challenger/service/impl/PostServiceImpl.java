package com.example.challenger.service.impl;

import com.example.challenger.data.dao.PostDAO;
import com.example.challenger.data.domain.Post;
import com.example.challenger.data.domain.ProjectStatus;
import com.example.challenger.data.domain.Team;

import com.example.challenger.data.dto.PostDto.Response;
import com.example.challenger.data.dto.PostDto.Request;
import com.example.challenger.data.dto.PostDto.Update;

import com.example.challenger.data.repository.ProjectStatusRepository;
import com.example.challenger.data.repository.TeamRepository;
import com.example.challenger.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;
    private final ProjectStatusRepository projectStatusRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public PostServiceImpl(PostDAO postDAO, ProjectStatusRepository projectStatusRepository, TeamRepository teamRepository) {
        this.postDAO = postDAO;
        this.projectStatusRepository = projectStatusRepository;
        this.teamRepository = teamRepository;
    }

    //조회
    @Override
    @Transactional
    public Response getPost(Long id) {
        Post post = postDAO.selectPost(id);

        Response postResponseDto = Response.builder()
                .id(post.getId())
                .projectName(post.getProjectName())
                .githubPath(post.getGithubPath())
                .content(post.getContent())
                .imagePath(post.getImagePath())
                .teamId(post.getTeam().getId())
                .teamName(post.getTeam().getName())
                .statusId(post.getStatusValue().getId())
                .statusValue(post.getStatusValue().getStatus())
                .build();

        return postResponseDto;
    }

    //저장
    @Override
    public Response savePost(Request postDto) {
        System.out.println("postDto.getStatusId(): " + postDto.getStatusId());

        //먼저, 노예인 Team과 ProjectStatus 가져오기
        ProjectStatus statusID = projectStatusRepository.getById(postDto.getStatusId());
        Team TeamID = teamRepository.getById(postDto.getTeamId());
        System.out.println("statusID : " + TeamID);

        //그 다음, 주인 Post 객체 생성
        Post post = new Post();
        post.setProjectName(postDto.getProjectName());
        post.setGithubPath(postDto.getGithubPath());
        post.setContent(postDto.getContent());
        post.setImagePath(postDto.getImagePath());
        post.setTeam(TeamID);
        post.setStatusValue(statusID);

        Post savedPostStatus = postDAO.insertPost(post);
        System.out.println("savedPostStatus : " + savedPostStatus.getProjectName());
        System.out.println("getTeamId : " + savedPostStatus.getTeam().getId());
        System.out.println("getStatusId : " + savedPostStatus.getStatusValue().getId());
        System.out.println("getStatus : " + savedPostStatus.getStatusValue().getStatus());

        Response postResponseDto = Response.builder()
                .id(savedPostStatus.getId())
                .projectName(savedPostStatus.getProjectName())
                .githubPath(savedPostStatus.getGithubPath())
                .content(savedPostStatus.getContent())
                .imagePath(savedPostStatus.getImagePath())
                .teamId(savedPostStatus.getTeam().getId())
                .teamName(savedPostStatus.getTeam().getName())
                .statusId(savedPostStatus.getStatusValue().getId())
                .statusValue(savedPostStatus.getStatusValue().getStatus())
                .build();

        return postResponseDto;
    }

    //업데이트
    @Override
    @Transactional
    public Response updatePost(Update updatePostDto) throws Exception {
        Post post = new Post();
        post.setId(updatePostDto.getId());
        post.setProjectName(updatePostDto.getProjectName());
        post.setGithubPath(updatePostDto.getGithubPath());
        post.setContent(updatePostDto.getContent());
        post.setImagePath(updatePostDto.getImagePath());

        Post changedPost = postDAO.updatePost(post);

        Response postResponseDto = Response.builder()
                .id(changedPost.getId())
                .projectName(changedPost.getProjectName())
                .githubPath(changedPost.getGithubPath())
                .content(changedPost.getContent())
                .imagePath(changedPost.getImagePath())
                .teamId(changedPost.getTeam().getId())
                .teamName(changedPost.getTeam().getName())
                .statusId(changedPost.getStatusValue().getId())
                .statusValue(changedPost.getStatusValue().getStatus())
                .build();
        return postResponseDto;
    }

    @Override
    public void deletePost(Long id) throws Exception {
        postDAO.deletePost(id);
    }
}