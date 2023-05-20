package com.example.challenger.service;

import com.example.challenger.data.domain.ProjectStatus;
import com.example.challenger.data.domain.Team;
import com.example.challenger.data.dto.PostDto;
import com.example.challenger.data.dto.PostResponseDto;

public interface PostService {
    PostResponseDto getPost(Long id);
    PostResponseDto savePost(PostDto postDto);
    PostResponseDto updatePost(Long id, String projectName, String githubPath,
                               String content, String imagePath) throws Exception;
    void deletePost(Long id) throws Exception;
}