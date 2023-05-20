package com.example.challenger.controller;

import com.example.challenger.data.dto.TeamMemberDTO;
import com.example.challenger.data.dto.TeamMemberResponseDTO;
import com.example.challenger.data.dto.UpdateTeamMemberNameDTO;
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
    public TeamMemberResponseDTO getMemberInfo(Long id) {
        TeamMemberResponseDTO teamMemberResponseDTO = teamMemberService.getMemberInfo(id);
        return teamMemberResponseDTO;
    }

    //    팀 멤버 추가
    @PostMapping("v1/add")
    @Transactional
    public ResponseEntity<TeamMemberResponseDTO> addTeam(@RequestBody TeamMemberDTO teamMemberDTO) {
        TeamMemberResponseDTO teamMemberResponseDTO = teamMemberService.saveTeamMember(teamMemberDTO);
        return ResponseEntity.status(HttpStatus.OK).body(teamMemberResponseDTO);
    }

    //    멤버 삭제 by Id
    @DeleteMapping("v1/delete")
    public ResponseEntity<String> deleteTeamMember(Long id) throws Exception {
        teamMemberService.deleteTeamMember(id);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

    //    멤버 이름 변경
    @PutMapping("v1/update")
    public ResponseEntity<TeamMemberResponseDTO> updateTeamMemberName(@RequestBody UpdateTeamMemberNameDTO updateTeamMemberNameDTO) throws Exception {
        TeamMemberResponseDTO teamMemberResponseDTO = teamMemberService.updateTeamMemberName(updateTeamMemberNameDTO.getId(), updateTeamMemberNameDTO.getName());
        return ResponseEntity.status(HttpStatus.OK).body(teamMemberResponseDTO);
    }
}