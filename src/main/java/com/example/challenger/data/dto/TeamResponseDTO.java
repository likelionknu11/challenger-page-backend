package com.example.challenger.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamResponseDTO {
    private Long id;
    private String name;

    public TeamResponseDTO() {}
    public TeamResponseDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
