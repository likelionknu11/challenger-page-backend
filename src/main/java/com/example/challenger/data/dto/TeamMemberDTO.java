package com.example.challenger.data.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeamMemberDto {
    private String name;
    private String position;
    private Long teamId;
}