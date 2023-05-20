package com.example.challenger.data.dto;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TeamDTO {
    private String name;

    public TeamDTO(String name) {
        this.name = name;
    }
}