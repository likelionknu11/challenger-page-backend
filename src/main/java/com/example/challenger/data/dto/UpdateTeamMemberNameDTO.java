package com.example.challenger.data.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateTeamMemberNameDto {
    private Long id;
    private String name;
}