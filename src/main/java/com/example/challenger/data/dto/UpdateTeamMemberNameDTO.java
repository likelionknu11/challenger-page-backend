package com.example.challenger.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTeamMemberNameDTO {
    private Long id;
    private String name;

    public UpdateTeamMemberNameDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public UpdateTeamMemberNameDTO() {}
}