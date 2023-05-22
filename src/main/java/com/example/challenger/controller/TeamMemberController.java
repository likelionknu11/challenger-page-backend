package com.example.challenger.controller;

import com.example.challenger.data.dto.TeamMemberDto;
import com.example.challenger.data.dto.TeamMemberResponseDto;
import com.example.challenger.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("member")
public class TeamMemberController {
    private final TeamMemberService teamMemberService;

    @Autowired
    public TeamMemberController(TeamMemberService teamMemberService) {
        this.teamMemberService = teamMemberService;
    }

    //    멤버 정보 조회 by Id
    @GetMapping("v1/info")
    public TeamMemberResponseDto getMemberInfo(Long id) {
        TeamMemberResponseDto teamMemberResponseDto = teamMemberService.getMemberInfo(id);
        return teamMemberResponseDto;
    }

    //    팀 멤버 추가
    @PostMapping("v1/add")
    @Transactional
    public ResponseEntity<TeamMemberResponseDto> addTeam(@RequestBody TeamMemberDto teamMemberDto) {
        TeamMemberResponseDto teamMemberResponseDto = teamMemberService.saveTeamMember(teamMemberDto);
        return ResponseEntity.status(HttpStatus.OK).body(teamMemberResponseDto);
    }

    //    멤버 삭제 by Id
    @DeleteMapping("v1/delete")
    public ResponseEntity<String> deleteTeamMember(Long id) throws Exception {
        teamMemberService.deleteTeamMember(id);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

    //    멤버 이름 변경
    @PutMapping("v1/update")
    public ResponseEntity<TeamMemberResponseDto> updateTeamMemberName(@RequestBody TeamMemberDto teamMemberDto) throws Exception {
        TeamMemberResponseDto teamMemberResponseDto = teamMemberService.updateTeamMemberName(teamMemberDto);
        return ResponseEntity.status(HttpStatus.OK).body(teamMemberResponseDto);
    }
}