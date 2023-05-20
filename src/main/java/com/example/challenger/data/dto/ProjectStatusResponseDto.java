package com.example.challenger.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectStatusResponseDto {
    private Long id;
    private String status;

    public ProjectStatusResponseDto() {}
    public ProjectStatusResponseDto(Long id, String status) {
        this.id = id;
        this.status = status;
    }
}