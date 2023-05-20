package com.example.challenger.service.impl;

import com.example.challenger.data.dao.TeamMemberDAO;
import com.example.challenger.data.domain.Member;
import com.example.challenger.data.domain.Team;
import com.example.challenger.data.dto.TeamMemberDTO;
import com.example.challenger.data.dto.TeamMemberResponseDTO;
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
    public TeamMemberResponseDTO getMemberInfo(Long id) {
        Optional<Member> selectedmember = teamMemberDAO.getMemberInfo(id);

        TeamMemberResponseDTO teamMemberResponseDTO = new TeamMemberResponseDTO();
        if(selectedmember.isPresent()) {
            teamMemberResponseDTO.setId(selectedmember.get().getId());
            teamMemberResponseDTO.setName(selectedmember.get().getName());
            teamMemberResponseDTO.setPosition(selectedmember.get().getPosition());
            teamMemberResponseDTO.setTeamId(selectedmember.get().getTeam().getId());
            teamMemberResponseDTO.setTeamName(selectedmember.get().getTeam().getName());
        }

        return teamMemberResponseDTO;
    }

    @Override
    public TeamMemberResponseDTO saveTeamMember(TeamMemberDTO teamMemberDTO) {
        Team selectTeam = teamRepository.getById(teamMemberDTO.getTeamId());

        Member newMember = new Member();
        newMember.setName(teamMemberDTO.getName());
        newMember.setPosition(teamMemberDTO.getPosition());
        newMember.setTeam(selectTeam);

        Member savedMember = teamMemberDAO.addMember(newMember);

        TeamMemberResponseDTO teamMemberResponseDTO = new TeamMemberResponseDTO();
        teamMemberResponseDTO.setId(savedMember.getId());
        teamMemberResponseDTO.setName(savedMember.getName());
        teamMemberResponseDTO.setPosition(savedMember.getPosition());
        teamMemberResponseDTO.setTeamId(savedMember.getTeam().getId());
        teamMemberResponseDTO.setTeamName(savedMember.getTeam().getName());

        return teamMemberResponseDTO;
    }

    @Override
    public TeamMemberResponseDTO updateTeamMemberName(Long id, String name) throws Exception {
        Member updatedTeamMemberName = teamMemberDAO.updateTeamMemberName(id, name);

        TeamMemberResponseDTO teamMemberResponseDTO = new TeamMemberResponseDTO();
        teamMemberResponseDTO.setId(updatedTeamMemberName.getId());
        teamMemberResponseDTO.setName(updatedTeamMemberName.getName());
        teamMemberResponseDTO.setPosition(updatedTeamMemberName.getPosition());
        teamMemberResponseDTO.setTeamId(updatedTeamMemberName.getTeam().getId());
        teamMemberResponseDTO.setTeamName(updatedTeamMemberName.getTeam().getName());

        return teamMemberResponseDTO;
    }

    @Override
    public void deleteTeamMember(Long id) throws Exception {
        teamMemberDAO.deleteMember(id);
    }
}