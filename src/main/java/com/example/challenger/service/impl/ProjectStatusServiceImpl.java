package com.example.challenger.service.impl;

import com.example.challenger.data.dao.ProjectStatusDAO;
import com.example.challenger.data.domain.ProjectStatus;
import com.example.challenger.data.dto.ProjectStatusDto;
import com.example.challenger.data.dto.ProjectStatusResponseDto;
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
    public ProjectStatusResponseDto getProjectStatus(Long id) {
        ProjectStatus projectStatus = projectStatusDAO.selectProjectStatus(id);

        ProjectStatusResponseDto projectStatusResponseDto = new ProjectStatusResponseDto();
        projectStatusResponseDto.setId(projectStatus.getId());
        projectStatusResponseDto.setStatus(projectStatus.getStatus());

        return projectStatusResponseDto;
    }

    // status 값으로 정보 찾기.
    @Override
    @Transactional
    public ProjectStatusResponseDto getProjectStatus(String status) {
        ProjectStatus projectStatus = projectStatusDAO.selectProjectStatus(status);

        ProjectStatusResponseDto projectStatusResponseDto = new ProjectStatusResponseDto();
        projectStatusResponseDto.setId(projectStatus.getId());
        projectStatusResponseDto.setStatus(projectStatus.getStatus());

        return projectStatusResponseDto;
    }

    //저장
    @Override
    public ProjectStatusResponseDto saveProjectStatus(ProjectStatusDto projectStatusDto) {
        ProjectStatus projectStatus = new ProjectStatus();
        projectStatus.setStatus(projectStatusDto.getStatus());

        ProjectStatus savedProjectStatus = projectStatusDAO.insertProjectStatus(projectStatus);

        ProjectStatusResponseDto projectStatusResponseDto = new ProjectStatusResponseDto();
        projectStatusResponseDto.setId(savedProjectStatus.getId());
        projectStatusResponseDto.setStatus(savedProjectStatus.getStatus());

        return projectStatusResponseDto;
    }

    //업데이트
    @Override
    public ProjectStatusResponseDto updateProjectStatus(Long id, String status) throws Exception {
        ProjectStatus changedProjectStatus = projectStatusDAO.updateProjectStatus(id, status);

        ProjectStatusResponseDto projectStatusResponseDto = new ProjectStatusResponseDto();
        projectStatusResponseDto.setId(changedProjectStatus.getId());
        projectStatusResponseDto.setStatus(changedProjectStatus.getStatus());

        return projectStatusResponseDto;
    }

    @Override
    public void deleteProjectStatus(Long id) throws Exception {
        projectStatusDAO.deleteProjectStatus(id);
    }
}