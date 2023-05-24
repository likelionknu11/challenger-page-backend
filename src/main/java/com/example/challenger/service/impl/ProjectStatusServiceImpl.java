package com.example.challenger.service.impl;

import com.example.challenger.data.dao.ProjectStatusDAO;
import com.example.challenger.data.domain.ProjectStatus;

import com.example.challenger.data.dto.ProjectStatus.ResponseDto;
import com.example.challenger.data.dto.ProjectStatus.RequestDto;
import com.example.challenger.data.dto.ProjectStatus.UpdateDto;

import com.example.challenger.service.ProjectStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProjectStatusServiceImpl implements ProjectStatusService {
    private final ProjectStatusDAO projectStatusDAO;
    @Autowired
    public ProjectStatusServiceImpl(ProjectStatusDAO projectStatusDAO) {
        this.projectStatusDAO = projectStatusDAO;
    }

    //조회
    //could not initialize proxy - no Session 오류 발생 -> 영속성과 관련한 문제.
    //Transactional 어노테이션 넣어서 해결!
    @Override
    @Transactional
    public ResponseDto getProjectStatus(Long id) {
        ProjectStatus projectStatus = projectStatusDAO.selectProjectStatus(id);

        ResponseDto projectStatusResponseDto = ResponseDto.builder()
                .id(projectStatus.getId())
                .status(projectStatus.getStatus())
                .build();

        return projectStatusResponseDto;
    }

    // status 값으로 정보 찾기.
    @Override
    @Transactional
    public ResponseDto getProjectStatus(String status) {
        ProjectStatus projectStatus = projectStatusDAO.selectProjectStatus(status);

        ResponseDto projectStatusResponseDto = ResponseDto.builder()
                .id(projectStatus.getId())
                .status(projectStatus.getStatus())
                .build();

        return projectStatusResponseDto;
    }

    //저장
    @Override
    public ResponseDto saveProjectStatus(RequestDto projectStatusDto) {
        ProjectStatus projectStatus = new ProjectStatus();
        projectStatus.setStatus(projectStatusDto.getStatus());

        ProjectStatus savedProjectStatus = projectStatusDAO.insertProjectStatus(projectStatus);

        ResponseDto projectStatusResponseDto = ResponseDto.builder()
                .id(savedProjectStatus.getId())
                .status(savedProjectStatus.getStatus())
                .build();

        return projectStatusResponseDto;
    }

    //업데이트
    @Override
    public ResponseDto updateProjectStatus(UpdateDto updateDto) throws Exception {
        ProjectStatus projectStatus = new ProjectStatus();
        projectStatus.setId(updateDto.getId());
        projectStatus.setStatus(updateDto.getStatus());

        ProjectStatus changedProjectStatus = projectStatusDAO.updateProjectStatus(projectStatus);

        ResponseDto projectStatusResponseDto = ResponseDto.builder()
                .id(changedProjectStatus.getId())
                .status(changedProjectStatus.getStatus())
                .build();

        return projectStatusResponseDto;
    }

    @Override
    public void deleteProjectStatus(Long id) throws Exception {
        projectStatusDAO.deleteProjectStatus(id);
    }
}