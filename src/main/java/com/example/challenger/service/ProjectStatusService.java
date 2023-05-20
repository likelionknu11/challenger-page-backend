package com.example.challenger.service;

import com.example.challenger.data.dto.ProjectStatusDto;
import com.example.challenger.data.dto.ProjectStatusResponseDto;

public interface ProjectStatusService {
    ProjectStatusResponseDto getProjectStatus(Long id);
    // -값으로 정보 찾기
    ProjectStatusResponseDto getProjectStatus(String status);
    ProjectStatusResponseDto saveProjectStatus(ProjectStatusDto projectStatusDto);
    ProjectStatusResponseDto updateProjectStatus(Long id, String status) throws Exception;
    void deleteProjectStatus(Long id) throws Exception;
}