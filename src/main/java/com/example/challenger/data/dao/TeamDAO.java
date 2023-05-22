package com.example.challenger.data.dao;

import com.example.challenger.data.domain.Team;
import java.util.Optional;

public interface TeamDAO {
    Team insertTeam(Team team);
    Optional<Team> selectTeam(Long id);
    Team updateTeamName(Team team) throws Exception;
    void deleteTeam(Long id) throws Exception;
}