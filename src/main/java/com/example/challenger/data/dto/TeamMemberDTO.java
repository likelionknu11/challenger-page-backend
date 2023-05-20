package com.example.challenger.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class TeamMemberDTO {
    private String name;
    private String position;
    private Long teamId;

    public TeamMemberDTO(String name, String position, Long teamId) {
        this.name = name;
        this.position = position;
        this.teamId = teamId;
    }
}