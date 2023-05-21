package com.example.challenger.data.dto;
import com.example.challenger.data.domain.Team;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TeamDto {
    private Long id;
    private String name;

    public Team savingToEntity() {
        return Team.builder()
                .name(name)
                .build();
    }

    public Team updateToEntity() {
        return Team.builder()
                .id(id)
                .name(name)
                .build();
    }
}