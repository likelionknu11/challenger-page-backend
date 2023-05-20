package com.example.challenger.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProjectStatusDto {
    private Long id;
    private String status;

    public UpdateProjectStatusDto() {}
    public UpdateProjectStatusDto(Long id, String status) {
        this.id = id;
        this.status = status;
    }
}