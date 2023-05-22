package com.example.challenger.service;

import com.example.challenger.data.dto.TeamMemberDto;
import com.example.challenger.data.dto.TeamMemberResponseDto;

public interface TeamMemberService {
    TeamMemberResponseDto saveTeamMember(TeamMemberDto teamMemberDto);
    TeamMemberResponseDto getMemberInfo(Long id);
    TeamMemberResponseDto updateTeamMemberName(TeamMemberDto teamMemberDto) throws Exception;
    void deleteTeamMember(Long id) throws Exception;
}