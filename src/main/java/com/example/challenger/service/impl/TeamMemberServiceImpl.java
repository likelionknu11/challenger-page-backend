package com.example.challenger.service.impl;

import com.example.challenger.data.dao.TeamMemberDAO;
import com.example.challenger.data.domain.Member;
import com.example.challenger.data.domain.Team;
import com.example.challenger.data.dto.TeamMemberDto;
import com.example.challenger.data.dto.TeamMemberResponseDto;
import com.example.challenger.data.repository.TeamRepository;
import com.example.challenger.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {
    private final TeamMemberDAO teamMemberDAO;
    private final TeamRepository teamRepository;
    @Autowired
    public TeamMemberServiceImpl(TeamMemberDAO teamMemberDAO, TeamRepository teamRepository) {
        this.teamMemberDAO = teamMemberDAO;
        this.teamRepository = teamRepository;
    }

    @Override
    public TeamMemberResponseDto getMemberInfo(Long id) {
        Optional<Member> selectedmember = teamMemberDAO.getMemberInfo(id);

        TeamMemberResponseDto teamMemberResponseDto = new TeamMemberResponseDto();
        if(selectedmember.isPresent()) {
            teamMemberResponseDto.setId(selectedmember.get().getId());
            teamMemberResponseDto.setName(selectedmember.get().getName());
            teamMemberResponseDto.setPosition(selectedmember.get().getPosition());
            teamMemberResponseDto.setTeamId(selectedmember.get().getTeam().getId());
            teamMemberResponseDto.setTeamName(selectedmember.get().getTeam().getName());
        }

        return teamMemberResponseDto;
    }

    @Override
    public TeamMemberResponseDto saveTeamMember(TeamMemberDto teamMemberDto) {
        Team selectTeam = teamRepository.getById(teamMemberDto.getTeamId());

        Member newMember = new Member();
        newMember.setName(teamMemberDto.getName());
        newMember.setPosition(teamMemberDto.getPosition());
        newMember.setTeam(selectTeam);

        Member savedMember = teamMemberDAO.addMember(newMember);

        TeamMemberResponseDto teamMemberResponseDto = new TeamMemberResponseDto();
        teamMemberResponseDto.setId(savedMember.getId());
        teamMemberResponseDto.setName(savedMember.getName());
        teamMemberResponseDto.setPosition(savedMember.getPosition());
        teamMemberResponseDto.setTeamId(savedMember.getTeam().getId());
        teamMemberResponseDto.setTeamName(savedMember.getTeam().getName());

        return teamMemberResponseDto;
    }

    @Override
    public TeamMemberResponseDto updateTeamMemberName(Long id, String name) throws Exception {
        Member updatedTeamMemberName = teamMemberDAO.updateTeamMemberName(id, name);

        TeamMemberResponseDto teamMemberResponseDto = new TeamMemberResponseDto();
        teamMemberResponseDto.setId(updatedTeamMemberName.getId());
        teamMemberResponseDto.setName(updatedTeamMemberName.getName());
        teamMemberResponseDto.setPosition(updatedTeamMemberName.getPosition());
        teamMemberResponseDto.setTeamId(updatedTeamMemberName.getTeam().getId());
        teamMemberResponseDto.setTeamName(updatedTeamMemberName.getTeam().getName());

        return teamMemberResponseDto;
    }

    @Override
    public void deleteTeamMember(Long id) throws Exception {
        teamMemberDAO.deleteMember(id);
    }
}