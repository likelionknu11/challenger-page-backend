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
    public ResponseEntity<TeamResponseDTO> getTeamInfo(Long id){
        TeamResponseDTO teamResponseDTO = teamService.getTeamNameById(id);

        return ResponseEntity.status(HttpStatus.OK).body(teamResponseDTO);
    }

    @GetMapping("v1/get/member")
    public ResponseEntity<List<GetAllTeamMemberResponseDTO>> getAllTeamMembers(Long id) {
        List<GetAllTeamMemberResponseDTO> getAllTeamMemberResponseDTO = teamService.getAllTeamMember(id);

        return ResponseEntity.status(HttpStatus.OK).body(getAllTeamMemberResponseDTO);
    }

    @PostMapping("v1/create")
    public ResponseEntity<TeamResponseDTO> createTeam(@RequestBody TeamDTO teamDTO) {
        TeamResponseDTO teamResponseDTO = teamService.saveTeam(teamDTO);

        return ResponseEntity.status(HttpStatus.OK).body(teamResponseDTO);
    }

    @PutMapping("v1/update")
    public ResponseEntity<TeamResponseDTO> updateTeamName(@RequestBody UpdateTeamNameDTO updateTeamNameDTO) throws Exception {
        TeamResponseDTO teamResponseDTO = teamService.updateTeamName(updateTeamNameDTO.getId(), updateTeamNameDTO.getName());

        return ResponseEntity.status(HttpStatus.OK).body(teamResponseDTO);
    }

    @DeleteMapping("v1/delete")
    public ResponseEntity<String> deleteTeam(Long id) throws Exception {
        teamService.deleteTeam(id);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}