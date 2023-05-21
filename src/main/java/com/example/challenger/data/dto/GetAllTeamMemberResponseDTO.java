package com.example.challenger.data.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class GetAllTeamMemberResponseDto {
    private Long id;
    private String name;
    private String position;
}