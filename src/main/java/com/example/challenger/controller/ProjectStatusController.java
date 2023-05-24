package com.example.challenger.controller;

import com.example.challenger.data.dto.ProjectStatus.ResponseDto;
import com.example.challenger.data.dto.ProjectStatus.RequestDto;
import com.example.challenger.data.dto.ProjectStatus.UpdateDto;

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
    public ResponseEntity<ResponseDto> getProjectStatus(Long id) {
        ResponseDto projectStatusResponseDto = projectStatusService.getProjectStatus(id);
        return ResponseEntity.status(HttpStatus.OK).body(projectStatusResponseDto);
    }
    // status 값으로 해당하는 id 값 찾기.
    // (문제) status값이 중복일 때, 오류 발생.
    @GetMapping("/get/{status}")
    public ResponseEntity<Long> getProjectStatus(@PathVariable String status) {
        ResponseDto projectStatusResponseDto = projectStatusService.getProjectStatus(status);
        return ResponseEntity.status(HttpStatus.OK).body(projectStatusResponseDto.getId());
    }

    @PostMapping("/post")
    public ResponseEntity<ResponseDto> createProjectStatus(@RequestBody RequestDto projectStatusDto) {
        ResponseDto projectStatusResponseDto = projectStatusService.saveProjectStatus(projectStatusDto);

        return ResponseEntity.status(HttpStatus.OK).body(projectStatusResponseDto);
    }

    @PutMapping("/put")
    public ResponseEntity<ResponseDto>updateProjectStatus(
            @RequestBody UpdateDto updateProjectStatusDto) throws Exception{
        ResponseDto productResponseDto = projectStatusService.updateProjectStatus(updateProjectStatusDto);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProjectStatus(Long id) throws Exception {
        projectStatusService.deleteProjectStatus(id);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}