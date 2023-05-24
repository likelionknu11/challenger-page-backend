package com.example.challenger.service;

import com.example.challenger.data.dto.ProjectStatus.ResponseDto;
import com.example.challenger.data.dto.ProjectStatus.RequestDto;
import com.example.challenger.data.dto.ProjectStatus.UpdateDto;

public interface ProjectStatusService {
    ResponseDto getProjectStatus(Long id);
    // -값으로 정보 찾기
    ResponseDto getProjectStatus(String status);
    ResponseDto saveProjectStatus(RequestDto projectStatusDto);
    ResponseDto updateProjectStatus(UpdateDto updateProjectStatusDto) throws Exception;
    void deleteProjectStatus(Long id) throws Exception;
}