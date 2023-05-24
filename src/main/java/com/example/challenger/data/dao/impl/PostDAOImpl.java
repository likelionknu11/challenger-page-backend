package com.example.challenger.data.dao.impl;

import com.example.challenger.data.dao.PostDAO;
import com.example.challenger.data.domain.Post;
import com.example.challenger.data.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostDAOImpl implements PostDAO {

    private final PostRepository postRepository;

    @Autowired
    public PostDAOImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Post 엔티티를 DB에 저장
    @Override
    public Post insertPost(Post post) {
        try {
            Post savedPost = postRepository.save(post);
            return savedPost;
        } catch (DataAccessException e) {
            // 예외 처리 로직 작성
            e.printStackTrace();
            throw new RuntimeException("Failed to insert post into database", e);
        }
    }

    // *저장된 정보 선택
    // id 값으로 정보 찾기
    @Override
    public Post selectPost(Long id) {
        Post selectPost = postRepository.getById(id);
        return selectPost;
    }

    // Post 업데이트
    @Override
    public Post updatePost(Post updatePost) throws Exception {
        Optional<Post> selectedPost = postRepository.findById(updatePost.getId());

        Post updatedPost;
        if(selectedPost.isPresent()) {
            Post post = selectedPost.get();

            post.setProjectName(updatePost.getProjectName());
            post.setGithubPath(updatePost.getGithubPath());
            post.setContent(updatePost.getContent());
            post.setImagePath(updatePost.getImagePath());

            updatedPost = postRepository.save(post);
        } else {
            throw new Exception();
        }
        return updatedPost;
    }

    @Override
    public void deletePost(Long id) throws Exception {
        Optional<Post> selectedPost = postRepository.findById(id);

        if(selectedPost.isPresent()) {
            Post post = selectedPost.get();

            postRepository.delete(post);
        } else {
            throw new Exception();
        }
    }
}