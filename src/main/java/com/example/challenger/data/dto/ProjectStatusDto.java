package com.example.challenger.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProjectStatusDto {
    private String status;

    public ProjectStatusDto(String status) {
        this.status = status;
    }
}