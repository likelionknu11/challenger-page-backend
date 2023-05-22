package com.example.challenger.data.dto;

import com.example.challenger.data.domain.Member;
import com.example.challenger.data.domain.Team;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamResponseDto {
    private Long id;
    private String name;

    public TeamResponseDto toDto(Team entity){
       return TeamResponseDto.builder()
               .id(entity.getId())
               .name(entity.getName())
               .build();
    }

}
