package com.example.challenger.data.dao;

import com.example.challenger.data.domain.Post;

public interface PostDAO {
    Post insertPost(Post post);
    Post selectPost(Long id); // id 값으로 정보찾기
    Post updatePost(Long id, String projectName, String githubPath,
                    String content, String imagePath) throws Exception;
    void deletePost(Long id) throws Exception;

}