package com.example.challenger.controller;

import com.example.challenger.data.dto.PostDto.Response;
import com.example.challenger.data.dto.PostDto.Request;
import com.example.challenger.data.dto.PostDto.Update;

import com.example.challenger.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping("postContent")
public class PostController {
    private final PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/get")
    public ResponseEntity<Response> getPost(Long id) {
        Response postResponseDto = postService.getPost(id);
        return ResponseEntity.status(HttpStatus.OK).body(postResponseDto);
    }

    @PostMapping("/post")
    @Transactional
    public ResponseEntity<Response> createPost(@RequestBody Request postDto) {
        Response postResponseDto = postService.savePost(postDto);

        return ResponseEntity.status(HttpStatus.OK).body(postResponseDto);
    }

    @PutMapping("/put")
    public ResponseEntity<Response>updatePost(
            @RequestBody Update updatePostDto) throws Exception{
        Response postResponseDto = postService.updatePost(updatePostDto);

        return ResponseEntity.status(HttpStatus.OK).body(postResponseDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePost(Long id) throws Exception {
        postService.deletePost(id);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}