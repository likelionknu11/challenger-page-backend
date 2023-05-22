package com.example.challenger.service.impl;

import com.example.challenger.data.dao.TeamDAO;
import com.example.challenger.data.dao.TeamMemberDAO;
import com.example.challenger.data.domain.Member;
import com.example.challenger.data.dto.TeamMemberDto;
import com.example.challenger.data.dto.TeamMemberResponseDto;
import com.example.challenger.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {
    private final TeamMemberDAO teamMemberDAO;
    private final TeamDAO teamDAO;
    @Autowired
    public TeamMemberServiceImpl(TeamMemberDAO teamMemberDAO, TeamDAO teamDAO) {
        this.teamMemberDAO = teamMemberDAO;
        this.teamDAO = teamDAO;
    }

    @Override
    public TeamMemberResponseDto getMemberInfo(Long id) {
        Member selectedmember = teamMemberDAO.getMemberInfo(id).get();
        TeamMemberResponseDto teamMemberResponseDto = new TeamMemberResponseDto();
        return teamMemberResponseDto.toDto(selectedmember);
    }

    @Override
    public TeamMemberResponseDto saveTeamMember(TeamMemberDto teamMemberDto) {
        teamMemberDto.setTeam(teamDAO.selectTeam(teamMemberDto.getTeamId()).get());
        Member savedMember = teamMemberDAO.addMember(teamMemberDto.toEntity());
        TeamMemberResponseDto teamMemberResponseDto = new TeamMemberResponseDto();
        return teamMemberResponseDto.toDto(savedMember);
    }

    @Override
    public TeamMemberResponseDto updateTeamMemberName(TeamMemberDto teamMemberDto) throws Exception {
        Member updatedMember = teamMemberDAO.updateTeamMemberName(teamMemberDto.updateToEntity());
        TeamMemberResponseDto teamMemberResponseDto = new TeamMemberResponseDto();
        return teamMemberResponseDto.toDto(updatedMember);
    }

    @Override
    public void deleteTeamMember(Long id) throws Exception {
        teamMemberDAO.deleteMember(id);
    }
}