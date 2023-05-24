package com.example.challenger.data.dto;

import lombok.*;

public class ProjectStatusDto {

    //(기존) ProjectStatusDTO
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestDto {
        private String status;
    }

    //(기존) ProjectStatusRedsponseDTO
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseDto {
        private Long id;
        private String status;
    }

    //(기존) UpdateProjectStatusDTO
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateDto {
        private Long id;
        private String status;
    }
}
