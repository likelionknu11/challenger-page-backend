package com.example.challenger.service;

import com.example.challenger.data.dto.TeamDto;
import com.example.challenger.data.dto.TeamMemberResponseDto;
import com.example.challenger.data.dto.TeamResponseDto;

import java.util.List;

public interface TeamService {
    TeamResponseDto getTeamNameById(Long id);
    List<TeamMemberResponseDto> getAllTeamMember(Long id);
    TeamResponseDto saveTeam(TeamDto teamDto);
    TeamResponseDto updateTeamName(TeamDto teamDto) throws Exception;
    void deleteTeam(Long id) throws Exception;
}