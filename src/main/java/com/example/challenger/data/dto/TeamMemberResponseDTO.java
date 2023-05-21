package com.example.challenger.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TeamMemberResponseDto {
    private Long id;
    private String name;
    private String position;
    private Long teamId;
    private String teamName;
}
