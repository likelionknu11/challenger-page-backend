package com.example.challenger.service;

import com.example.challenger.data.dao.TeamDAO;
import com.example.challenger.data.dao.TeamMemberDAO;
import com.example.challenger.data.domain.Member;
import com.example.challenger.data.domain.Team;
import com.example.challenger.data.dto.TeamMemberDto;
import com.example.challenger.data.dto.TeamMemberResponseDto;
import com.example.challenger.data.repository.TeamRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TeamMemberServiceTest {
    @Autowired
    TeamRepository teamRepository;

    @Autowired
    TeamDAO teamDAO;

    @Autowired
    TeamMemberDAO teamMemberDAO;

    @Test
    @DisplayName("Builder 테스트")
    void testBuilder() {
        String name = "테스트";
        String position = "백엔드";
        Long teamId = 14L;
        Team team = teamDAO.selectTeam(teamId).get();

        TeamMemberDto teamMemberDto = TeamMemberDto.builder()
                .name(name)
                .position(position)
                .team(team)
                .build();

        assertThat(teamMemberDto.getName()).isEqualTo(name);
        assertThat(teamMemberDto.getPosition()).isEqualTo(position);
        assertThat(teamMemberDto.getTeam()).isEqualTo(team);
    }

    @Test
    @DisplayName("새로운 멤버 추가")
    void createMember() {
        String name = "테스트";
        String position = "백엔드";
        Long teamId = 14L;
        Team team = teamDAO.selectTeam(teamId).get();

        TeamMemberDto teamMemberDto = TeamMemberDto.builder()
                .name(name)
                .position(position)
                .team(team)
                .build();
        System.out.println("Dto: " + teamMemberDto);

        Member savedMember = teamMemberDAO.addMember(teamMemberDto.toEntity());
        System.out.println("Saved: " + savedMember);

        TeamMemberResponseDto teamMemberResponseDto = new TeamMemberResponseDto();
        System.out.println("Done: " + teamMemberResponseDto.toDto(savedMember));
    }

    @Test
    @DisplayName("기존 팀 멤버 이름 업데이트")
    void updateMember() throws Exception {
        Long id = 1L;
        String name = "난윤난난";

        TeamMemberDto teamMemberDto = TeamMemberDto.builder()
                .id(id)
                .name(name)
                .build();
        System.out.println("Dto: " + teamMemberDto);

        Member updatedMember = teamMemberDAO.updateTeamMemberName(teamMemberDto.updateToEntity());
        System.out.println("Saved: " + updatedMember);

        TeamMemberResponseDto teamMemberResponseDto = new TeamMemberResponseDto();
        System.out.println("Done: " + teamMemberResponseDto.toDto(updatedMember));
    }
}
