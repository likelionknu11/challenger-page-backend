package com.example.challenger.controller;

import com.example.challenger.data.dto.PostDto;
import com.example.challenger.data.dto.PostResponseDto;
import com.example.challenger.data.dto.UpdatePostDto;
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
    public ResponseEntity<PostResponseDto> getPost(Long id) {
        PostResponseDto postResponseDto = postService.getPost(id);
        return ResponseEntity.status(HttpStatus.OK).body(postResponseDto);
    }

    @PostMapping("/post")
    @Transactional
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostDto postDto) {
        PostResponseDto postResponseDto = postService.savePost(postDto);

        return ResponseEntity.status(HttpStatus.OK).body(postResponseDto);
    }

    @PutMapping("/put")
    public ResponseEntity<PostResponseDto>updatePost(
            @RequestBody UpdatePostDto updatePostDto) throws Exception{
        PostResponseDto postResponseDto = postService.updatePost(
                updatePostDto.getId(), updatePostDto.getProjectName(),
                updatePostDto.getGithubPath(), updatePostDto.getContent(),
                updatePostDto.getImagePath());

        return ResponseEntity.status(HttpStatus.OK).body(postResponseDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePost(Long id) throws Exception {
        postService.deletePost(id);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}