package com.example.challenger.data.repository;

import com.example.challenger.data.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}