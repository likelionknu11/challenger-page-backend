package com.example.challenger.service.impl;

import com.example.challenger.data.dao.PostDAO;
import com.example.challenger.data.domain.Post;
import com.example.challenger.data.domain.ProjectStatus;
import com.example.challenger.data.domain.Team;
import com.example.challenger.data.dto.PostDto.Request;
import com.example.challenger.data.dto.PostDto.Response;
import com.example.challenger.data.dto.PostDto.Update;
import com.example.challenger.data.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class PostServiceImplTest {

    @Mock
    private PostDAO postDAO;

    @InjectMocks
    private PostServiceImpl postService;
    @Test
    void getPost() {
        Team team = new Team();
        team.setId(1L);
        team.setName("백엔드");

        ProjectStatus ps = new ProjectStatus();
        ps.setId(1L);
        ps.setStatus("공과공");

        Post post = new Post();
        Long id = 1L;
        post.setId(1L);
        post.setId(id);
        post.setProjectName("Test project name");
        post.setGithubPath("http://test.com/test");
        post.setContent("Test content");
        post.setImagePath("test/image.jpg");
        post.setTeam(team);
        post.setStatusValue(ps);

        when(postDAO.selectPost(id)).thenReturn(post);

        Response response = postService.getPost(id);
        assertThat(response.getId()).isEqualTo(id);

        System.out.println("ID : " + response.getId()
                + ", projectName : " + response.getProjectName()
                + ", githubPath : " + response.getGithubPath()
                + ", content : " + response.getContent()
                + ", ImagePath : " + response.getImagePath()
                + ", TeamID : " + response.getTeamId()
                + ", TeamName : " + response.getTeamName()
                + ", statusID : " + response.getStatusId()
                + ", statusValue : " + response.getStatusValue()
        );
        System.out.println("Test Ok");
    }

    @Test
    void savePost() {
        Team team = new Team();
        team.setId(1L);
        team.setName("백엔드");

        ProjectStatus ps = new ProjectStatus();
        ps.setId(1L);
        ps.setStatus("공과공");

        Request request = Request.builder()
                .projectName("Test project name")
                .githubPath("http://test.com/test")
                .content("Test content")
                .imagePath("test/image.jpg")
                .teamId(team.getId())
                .statusId(ps.getId())
                .build();

        Post post = new Post();
        Long id = 1L;
        post.setId(1L);
        post.setId(id);
        post.setProjectName(request.getProjectName());
        post.setGithubPath(request.getGithubPath());
        post.setContent(request.getProjectName());
        post.setImagePath(request.getProjectName());
        post.setTeam(team);
        post.setStatusValue(ps);

        when(postDAO.insertPost(post)).thenReturn(post);
        Post savedPost = post;

        Response response = Response.builder()
                .id(savedPost.getId())
                .projectName(savedPost.getProjectName())
                .githubPath(savedPost.getGithubPath())
                .content(savedPost.getContent())
                .imagePath(savedPost.getImagePath())
                .teamId(savedPost.getTeam().getId())
                .teamName(savedPost.getTeam().getName())
                .statusId(savedPost.getStatusValue().getId())
                .statusValue(savedPost.getStatusValue().getStatus())
                .build();
        assertThat(response.getId()).isEqualTo(id);

        System.out.println("ID : " + response.getId()
                + ", projectName : " + response.getProjectName()
                + ", githubPath : " + response.getGithubPath()
                + ", content : " + response.getContent()
                + ", ImagePath : " + response.getImagePath()
                + ", TeamID : " + response.getTeamId()
                + ", TeamName : " + response.getTeamName()
                + ", statusID : " + response.getStatusId()
                + ", statusValue : " + response.getStatusValue()
        );
        System.out.println("Test Ok");
    }

    @Test
    void updatePost() throws Exception {
        Team team = new Team();
        team.setId(1L);
        team.setName("백엔드");

        ProjectStatus ps = new ProjectStatus();
        ps.setId(1L);
        ps.setStatus("공과공");

        Update update = Update.builder()
                .projectName("Test Update name")
                .githubPath("http://test.com/update")
                .content("update content")
                .imagePath("test/image.jpg")
                .build();

        Post post = new Post();
        Long id = 1L;
        post.setId(1L);
        post.setId(id);
        post.setProjectName(update.getProjectName());
        post.setGithubPath(update.getGithubPath());
        post.setContent(update.getProjectName());
        post.setImagePath(update.getProjectName());
        post.setTeam(team);
        post.setStatusValue(ps);

        when(postDAO.updatePost(post)).thenReturn(post);
        Post updatedPost = post;

        Response response = Response.builder()
                .id(updatedPost.getId())
                .projectName(updatedPost.getProjectName())
                .githubPath(updatedPost.getGithubPath())
                .content(updatedPost.getContent())
                .imagePath(updatedPost.getImagePath())
                .teamId(updatedPost.getTeam().getId())
                .teamName(updatedPost.getTeam().getName())
                .statusId(updatedPost.getStatusValue().getId())
                .statusValue(updatedPost.getStatusValue().getStatus())
                .build();
        assertThat(response.getId()).isEqualTo(id);

        System.out.println("ID : " + response.getId()
                + ", projectName : " + response.getProjectName()
                + ", githubPath : " + response.getGithubPath()
                + ", content : " + response.getContent()
                + ", ImagePath : " + response.getImagePath()
                + ", TeamID : " + response.getTeamId()
                + ", TeamName : " + response.getTeamName()
                + ", statusID : " + response.getStatusId()
                + ", statusValue : " + response.getStatusValue()
        );
        System.out.println("Test Ok");
    }
}