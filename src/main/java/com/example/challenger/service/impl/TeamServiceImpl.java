package com.example.challenger.service.impl;

import com.example.challenger.data.dao.TeamDAO;
import com.example.challenger.data.dao.TeamMemberDAO;
import com.example.challenger.data.domain.Member;
import com.example.challenger.data.domain.Team;
import com.example.challenger.data.dto.TeamDto;
import com.example.challenger.data.dto.TeamMemberResponseDto;
import com.example.challenger.data.dto.TeamResponseDto;
import com.example.challenger.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamDAO teamDAO;
    private final TeamMemberDAO teamMemberDAO;

    @Autowired
    public TeamServiceImpl(TeamDAO teamDAO, TeamMemberDAO teamMemberDAO) {
        this.teamDAO = teamDAO;
        this.teamMemberDAO = teamMemberDAO;
    }

    @Override
    public TeamResponseDto getTeamNameById(Long id) {
        Optional<Team> team = teamDAO.selectTeam(id);
        TeamResponseDto teamResponseDto = new TeamResponseDto();
        return teamResponseDto.toDto(team.get());
    }

    @Override
    public List<TeamMemberResponseDto> getAllTeamMember(Long id) {
        List<Member> members = teamMemberDAO.selectAllTeamMember(id);
        List<TeamMemberResponseDto> getAllTeamMemberDtoList = new ArrayList<>();

        for (Member member : members) {
            TeamMemberResponseDto teamMemberResponseDto = new TeamMemberResponseDto();
            getAllTeamMemberDtoList.add(teamMemberResponseDto.listToDto(member));
        }

        return getAllTeamMemberDtoList;
    }

    @Override
    public TeamResponseDto saveTeam(TeamDto teamDto) {
        Team savedTeam = teamDAO.insertTeam(teamDto.savingToEntity());
        TeamResponseDto teamResponseDto = new TeamResponseDto();
        return teamResponseDto.toDto(savedTeam);
    }

    @Override
    public TeamResponseDto updateTeamName(TeamDto teamDto) throws Exception {
        Team updatedTeamName = teamDAO.updateTeamName(teamDto.updateToEntity());
        TeamResponseDto teamResponseDto = new TeamResponseDto();
        return teamResponseDto.toDto(updatedTeamName);
    }

    @Override
    public void deleteTeam(Long id) throws Exception {
        teamDAO.deleteTeam(id);
    }

}