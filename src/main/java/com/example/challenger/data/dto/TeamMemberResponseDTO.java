package com.example.challenger.data.dto;

import com.example.challenger.data.domain.Member;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamMemberResponseDto {
    private Long id;
    private String name;
    private String position;
    private Long teamId;
    private String teamName;

    public TeamMemberResponseDto toDto(Member entity) {
        return TeamMemberResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .position(entity.getPosition())
                .teamId(entity.getTeam().getId())
                .teamName(entity.getTeam().getName())
                .build();
    }

    public TeamMemberResponseDto listToDto(Member entity) {
        return TeamMemberResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .position(entity.getPosition())
                .build();
    }

}
