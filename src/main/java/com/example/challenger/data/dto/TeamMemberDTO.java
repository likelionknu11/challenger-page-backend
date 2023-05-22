package com.example.challenger.data.dto;

import com.example.challenger.data.domain.Member;
import com.example.challenger.data.domain.Team;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeamMemberDto {
    private Long id;
    private String name;
    private String position;
    private Team team;
    private Long teamId;



    public Member toEntity() {
        return Member.builder()
                .name(name)
                .position(position)
                .team(team)
                .build();
    }

    public Member updateToEntity() {
        return Member.builder()
                .id(id)
                .name(name)
                .build();
    }
}