package com.example.challenger.controller;

import com.example.challenger.data.dto.*;
import com.example.challenger.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("team")
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("v1/get")
    public ResponseEntity<TeamResponseDto> getTeamInfo(Long id){
        TeamResponseDto teamResponseDto = teamService.getTeamNameById(id);

        return ResponseEntity.status(HttpStatus.OK).body(teamResponseDto);
    }

    @GetMapping("v1/get/member")
    public ResponseEntity<List<GetAllTeamMemberResponseDto>> getAllTeamMembers(Long id) {
        List<GetAllTeamMemberResponseDto> getAllTeamMemberResponseDto = teamService.getAllTeamMember(id);

        return ResponseEntity.status(HttpStatus.OK).body(getAllTeamMemberResponseDto);
    }

    @PostMapping("v1/create")
    public ResponseEntity<TeamResponseDto> createTeam(@RequestBody TeamDto teamDto) {
        TeamResponseDto teamResponseDto = teamService.saveTeam(teamDto);

        return ResponseEntity.status(HttpStatus.OK).body(teamResponseDto);
    }

    @PutMapping("v1/update")
    public ResponseEntity<TeamResponseDto> updateTeamName(@RequestBody TeamDto teamDto) throws Exception {
        TeamResponseDto teamResponseDto = teamService.updateTeamName(teamDto);

        return ResponseEntity.status(HttpStatus.OK).body(teamResponseDto);
    }

    @DeleteMapping("v1/delete")
    public ResponseEntity<String> deleteTeam(Long id) throws Exception {
        teamService.deleteTeam(id);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}