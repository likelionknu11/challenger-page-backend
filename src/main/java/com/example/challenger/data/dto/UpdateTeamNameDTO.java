package com.example.challenger.data.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTeamNameDTO {
    private Long id;
    private String name;

    public UpdateTeamNameDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public UpdateTeamNameDTO() {}
}