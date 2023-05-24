package com.example.challenger.service;

import com.example.challenger.data.dao.TeamDAO;
import com.example.challenger.data.domain.Team;
import com.example.challenger.data.dto.TeamDto;
import com.example.challenger.data.dto.TeamResponseDto;
import com.example.challenger.data.repository.TeamRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TeamServiceTest {
    @Autowired
    TeamRepository teamRepository;

    @Autowired
    TeamDAO teamDAO;

    @Test
    @DisplayName("Builder 테스트")
    void testBuilder() {
        Long id = 1L;
        String name = "팀이름";
        TeamDto teamDto = TeamDto.builder()
                .id(id)
                .name(name)
                .build();

        assertThat(teamDto.getId()).isEqualTo(id);
        assertThat(teamDto.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("새로운 팀 추가")
    void createTeam() {
        String name = "테스트팀1";
        TeamDto teamDto = TeamDto.builder()
                .name(name)
                .build();
        Team savedTeam = teamDAO.insertTeam(teamDto.savingToEntity());

        TeamResponseDto teamResponseDto = new TeamResponseDto();
        System.out.println(teamResponseDto.toDto(savedTeam));
    }

    @Test
    @DisplayName("팀 이름 업데이트")
    void updateTeamName() throws Exception {
        Long id = 2L;
        String name = "새로운 팀 이름";
        TeamDto teamDto = TeamDto.builder()
                .id(id)
                .name(name)
                .build();
        Team updatedTeamName = teamDAO.updateTeamName(teamDto.updateToEntity());
        TeamResponseDto teamResponseDto = new TeamResponseDto();
        System.out.println(teamResponseDto.toDto(updatedTeamName));
    }
}
