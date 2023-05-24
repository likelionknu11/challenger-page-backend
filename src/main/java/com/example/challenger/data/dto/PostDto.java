package com.example.challenger.data.dto;

import com.example.challenger.data.domain.Post;
import lombok.*;

public class PostDto {

    //(기존) PostDto
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private String projectName;
        private String githubPath;
        private String content;
        private String imagePath;
        private Long teamId;
        private Long statusId;
    }

    //(기존) PostResponseDto
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String projectName;
        private String githubPath;
        private String content;
        private String imagePath;
        private Long teamId;
        private String teamName;
        private Long statusId;
        private String statusValue;
    }



    //(기존) UpdatePostDto
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Update {
        private Long id;
        private String projectName;
        private String githubPath;
        private String content;
        private String imagePath;
    }
}
