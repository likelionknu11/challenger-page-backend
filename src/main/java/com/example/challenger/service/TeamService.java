package com.example.challenger.service;

import com.example.challenger.data.dto.GetAllTeamMemberResponseDTO;
import com.example.challenger.data.dto.TeamDTO;
import com.example.challenger.data.dto.TeamResponseDTO;

import java.util.List;

public interface TeamService {
    TeamResponseDTO getTeamNameById(Long id);
    List<GetAllTeamMemberResponseDTO> getAllTeamMember(Long id);
    TeamResponseDTO saveTeam(TeamDTO teamDTO);
    TeamResponseDTO updateTeamName(Long id, String name) throws Exception;
    void deleteTeam(Long id) throws Exception;
}