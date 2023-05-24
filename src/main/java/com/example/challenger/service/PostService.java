package com.example.challenger.service;

import com.example.challenger.data.dto.PostDto.Response;
import com.example.challenger.data.dto.PostDto.Request;
import com.example.challenger.data.dto.PostDto.Update;

public interface PostService {
    Response getPost(Long id);
    Response savePost(Request postDto);
    Response updatePost(Update updatePostDto) throws Exception;
    void deletePost(Long id) throws Exception;
}