package com.example.challenger.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private String projectName;
    private String githubPath;
    private String content;
    private String imagePath;
    private Long teamId;
    private String teamName;
    private Long statusId;
    private String statusValue;
    public PostResponseDto(Long id, String projectName, String githubPath, String content, String imagePath,
                           Long teamId, String teamName, Long statusId, String statusValue) {
        this.id = id;
        this.projectName = projectName;
        this.githubPath = githubPath;
        this.content = content;
        this.imagePath = imagePath;
        this.teamId = teamId;
        this.teamName = teamName;
        this.statusId = statusId;
        this.statusValue = statusValue;
    }
}