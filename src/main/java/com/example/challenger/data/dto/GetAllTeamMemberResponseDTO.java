package com.example.challenger.data.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class GetAllTeamMemberResponseDTO {
    private Long id;
    private String name;
    private String position;
}