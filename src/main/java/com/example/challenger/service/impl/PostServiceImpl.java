package com.example.challenger.service.impl;

import com.example.challenger.data.dao.PostDAO;
import com.example.challenger.data.domain.Post;
import com.example.challenger.data.domain.ProjectStatus;
import com.example.challenger.data.domain.Team;
import com.example.challenger.data.dto.PostDto;
import com.example.challenger.data.dto.PostResponseDto;
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
    public PostResponseDto getPost(Long id) {
        Post post = postDAO.selectPost(id);

        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setId(post.getId());

        postResponseDto.setProjectName(post.getProjectName());
        postResponseDto.setGithubPath(post.getGithubPath());
        postResponseDto.setContent(post.getContent());
        postResponseDto.setImagePath(post.getImagePath());
        postResponseDto.setTeamId(post.getTeam().getId());
        postResponseDto.setTeamName(post.getTeam().getName());
        postResponseDto.setStatusId(post.getStatusValue().getId());
        postResponseDto.setStatusValue(post.getStatusValue().getStatus());

        return postResponseDto;
    }

    //저장
    @Override
    public PostResponseDto savePost(PostDto postDto) {
        System.out.println("postDto.getStatusId(): " + postDto.getStatusId());

        ProjectStatus statusID = projectStatusRepository.getById(postDto.getStatusId());
        Team TeamID = teamRepository.getById(postDto.getTeamId());
        System.out.println("statusID : " + TeamID);

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

        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setId(savedPostStatus.getId());
        postResponseDto.setProjectName(savedPostStatus.getProjectName());
        postResponseDto.setGithubPath(savedPostStatus.getGithubPath());
        postResponseDto.setContent(savedPostStatus.getContent());
        postResponseDto.setImagePath(savedPostStatus.getImagePath());
        postResponseDto.setTeamId(savedPostStatus.getTeam().getId());
        postResponseDto.setTeamName(savedPostStatus.getTeam().getName());
        postResponseDto.setStatusId(savedPostStatus.getStatusValue().getId());
        postResponseDto.setStatusValue(savedPostStatus.getStatusValue().getStatus());

        return postResponseDto;
    }

    //업데이트
    @Override
    @Transactional
    public PostResponseDto updatePost(Long id, String projectName, String githubPath,
                                      String content, String imagePath) throws Exception {
        Post changedPost = postDAO.updatePost(id, projectName, githubPath, content, imagePath);

        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setId(changedPost.getId());
        postResponseDto.setProjectName(changedPost.getProjectName());
        postResponseDto.setGithubPath(changedPost.getGithubPath());
        postResponseDto.setContent(changedPost.getContent());
        postResponseDto.setImagePath(changedPost.getImagePath());
        postResponseDto.setTeamId(changedPost.getTeam().getId());
        postResponseDto.setStatusId(changedPost.getStatusValue().getId());

        return postResponseDto;
    }

    @Override
    public void deletePost(Long id) throws Exception {
        postDAO.deletePost(id);
    }
}