package com.example.challenger.data.dao.impl;

import com.example.challenger.data.dao.TeamDAO;
import com.example.challenger.data.domain.Team;
import com.example.challenger.data.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TeamDAOImpl implements TeamDAO {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamDAOImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team insertTeam(Team team) {
        Team savedTeam = teamRepository.save(team);
        return savedTeam;
    }

    @Override
    public Optional<Team> selectTeam(Long id) {
        return teamRepository.findById(id);
    }

    @Override
    public Team updateTeamName(Team team) throws Exception {
        Optional<Team> selectedTeam = teamRepository.findById(team.getId());
        Team updatedTeam;
        if(selectedTeam.isPresent()) {
            updatedTeam = teamRepository.save(team);
        } else {
            throw new Exception();
        }

        return updatedTeam;
    }

    @Override
    public void deleteTeam(Long id) throws Exception {
        Optional<Team> selectedTeam = teamRepository.findById(id);
        if(selectedTeam.isPresent()) {
            Team team = selectedTeam.get();
            teamRepository.delete(team);
        } else {
            throw new Exception();
        }
    }
}