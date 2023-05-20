package com.example.challenger.service.impl;

import com.example.challenger.data.dao.TeamDAO;
import com.example.challenger.data.dao.TeamMemberDAO;
import com.example.challenger.data.domain.Member;
import com.example.challenger.data.domain.Team;
import com.example.challenger.data.dto.GetAllTeamMemberResponseDTO;
import com.example.challenger.data.dto.TeamDTO;
import com.example.challenger.data.dto.TeamResponseDTO;
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
    public TeamResponseDTO getTeamNameById(Long id) {
        Optional<Team> team = teamDAO.selectTeam(id);
        TeamResponseDTO teamResponseDTO = new TeamResponseDTO();
        teamResponseDTO.setId(team.get().getId());
        teamResponseDTO.setName(team.get().getName());
        return teamResponseDTO;
    }

    @Override
    public List<GetAllTeamMemberResponseDTO> getAllTeamMember(Long id) {
        List<Member> members = teamMemberDAO.selectAllTeamMember(id);
        List<GetAllTeamMemberResponseDTO> getAllTeamMemberDTOList = new ArrayList<>();

        for(Member member : members) {
            GetAllTeamMemberResponseDTO getAllTeamMemberResponseDTO = new GetAllTeamMemberResponseDTO();
            getAllTeamMemberResponseDTO.setId(member.getId());
            getAllTeamMemberResponseDTO.setName(member.getName());
            getAllTeamMemberResponseDTO.setPosition(member.getPosition());
            getAllTeamMemberDTOList.add(getAllTeamMemberResponseDTO);
        }

        return getAllTeamMemberDTOList;
    }

    @Override
    public TeamResponseDTO saveTeam(TeamDTO teamDTO) {
        Team team = new Team();
        team.setName(teamDTO.getName());

        Team savedTeam = teamDAO.insertTeam(team);
        TeamResponseDTO teamResponseDTO = new TeamResponseDTO();
        teamResponseDTO.setId(savedTeam.getId());
        teamResponseDTO.setName(savedTeam.getName());

        return teamResponseDTO;
    }

    @Override
    public TeamResponseDTO updateTeamName(Long id, String name) throws Exception{
        Team updatedTeamName = teamDAO.updateTeamName(id, name);

        TeamResponseDTO teamResponseDTO = new TeamResponseDTO();
        teamResponseDTO.setId(updatedTeamName.getId());
        teamResponseDTO.setName(updatedTeamName.getName());

        return teamResponseDTO;
    }

    @Override
    public void deleteTeam(Long id) throws Exception {
        teamDAO.deleteTeam(id);
    }
}