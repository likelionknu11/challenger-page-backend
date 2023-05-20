package com.example.challenger.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private String projectName;
    private String githubPath;
    private String content;
    private String imagePath;
    private Long teamId;
    private Long statusId;
    public PostDto(String projectName, String githubPath, String content, String imagePath, Long teamId, Long statusId) {
        this.projectName = projectName;
        this.githubPath = githubPath;
        this.content = content;
        this.imagePath = imagePath;
        this.teamId = teamId;
        this.statusId = statusId;
    }
}