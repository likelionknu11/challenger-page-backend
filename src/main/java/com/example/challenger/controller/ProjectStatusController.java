package com.example.challenger.controller;

import com.example.challenger.data.dto.UpdateProjectStatusDto;
import com.example.challenger.data.dto.ProjectStatusDto;
import com.example.challenger.data.dto.ProjectStatusResponseDto;
import com.example.challenger.service.ProjectStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping("projectStatus")
public class ProjectStatusController {
    private final ProjectStatusService projectStatusService;
    @Autowired
    public ProjectStatusController(ProjectStatusService projectStatusService) {
        this.projectStatusService = projectStatusService;
    }

    @GetMapping("/get")
    public ResponseEntity<ProjectStatusResponseDto> getProjectStatus(Long id) {
        ProjectStatusResponseDto projectStatusResponseDto = projectStatusService.getProjectStatus(id);
        return ResponseEntity.status(HttpStatus.OK).body(projectStatusResponseDto);
    }
    // status 값으로 해당하는 id 값 찾기.
    // (문제) status값이 중복일 때, 오류 발생.
    @GetMapping("/get/{status}")
    public ResponseEntity<Long> getProjectStatus(@PathVariable String status) {
        ProjectStatusResponseDto projectStatusResponseDto = projectStatusService.getProjectStatus(status);
        return ResponseEntity.status(HttpStatus.OK).body(projectStatusResponseDto.getId());
    }

    @PostMapping("/post")
    public ResponseEntity<ProjectStatusResponseDto> createProjectStatus(@RequestBody ProjectStatusDto projectStatusDto) {
        ProjectStatusResponseDto projectStatusResponseDto = projectStatusService.saveProjectStatus(projectStatusDto);

        return ResponseEntity.status(HttpStatus.OK).body(projectStatusResponseDto);
    }

    @PutMapping("/put")
    public ResponseEntity<ProjectStatusResponseDto>updateProjectStatus(
            @RequestBody UpdateProjectStatusDto updateProjectStatusDto) throws Exception{
        ProjectStatusResponseDto productResponseDto = projectStatusService.updateProjectStatus(
                updateProjectStatusDto.getId(), updateProjectStatusDto.getStatus());

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProjectStatus(Long id) throws Exception {
        projectStatusService.deleteProjectStatus(id);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}