package com.example.challenger.service;

import com.example.challenger.data.dto.TeamMemberDTO;
import com.example.challenger.data.dto.TeamMemberResponseDTO;

import java.util.List;
import java.util.Optional;

public interface TeamMemberService {
    TeamMemberResponseDTO saveTeamMember(TeamMemberDTO teamMemberDTO);
    TeamMemberResponseDTO getMemberInfo(Long id);
    TeamMemberResponseDTO updateTeamMemberName(Long id, String name) throws Exception;
    void deleteTeamMember(Long id) throws Exception;
}