package com.example.challenger.data.dao.impl;

import com.example.challenger.data.dao.ProjectStatusDAO;
import com.example.challenger.data.domain.ProjectStatus;
import com.example.challenger.data.repository.ProjectStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Optional;

@Component
public class ProjectStatusDAOImpl implements ProjectStatusDAO {

    private final ProjectStatusRepository projectStatusRepository;

    @Autowired
    public ProjectStatusDAOImpl(ProjectStatusRepository projectStatusRepository) {
        this.projectStatusRepository = projectStatusRepository;
    }

    // ProjectStatus 엔티티를 DB에 저장
    @Override
    public ProjectStatus insertProjectStatus(ProjectStatus projectStatus) {
        ProjectStatus savedProjectStatus = projectStatusRepository.save(projectStatus);
        return savedProjectStatus;
    }

    // *저장된 정보 선택
    // id 값으로 정보 찾기
    @Override
    public ProjectStatus selectProjectStatus(Long id) {
        ProjectStatus selectProjectStatus = projectStatusRepository.getById(id);
        return selectProjectStatus;
    }

    // status 값으로 정보 찾기.
    @Override
    public ProjectStatus selectProjectStatus(String status) {
        ProjectStatus selectProjectStatus = projectStatusRepository.findByStatus(status);
        return selectProjectStatus;
    }

    // ProjectStatus 업데이트
    @Override
    public ProjectStatus updateProjectStatus(ProjectStatus updateProjectStatus) throws Exception {
        Optional<ProjectStatus> selectedProjectStatus = projectStatusRepository.findById(updateProjectStatus.getId());

        ProjectStatus updated_ProjectStauts;
        if(selectedProjectStatus.isPresent()) {
            ProjectStatus projectStatus = selectedProjectStatus.get();

            projectStatus.setStatus(updateProjectStatus.getStatus());

            updated_ProjectStauts = projectStatusRepository.save(projectStatus);
        } else {
            throw new Exception();
        }
        return updated_ProjectStauts;
    }

    @Override
    public void deleteProjectStatus(Long id) throws Exception {
        Optional<ProjectStatus> selectedProjectStatus = projectStatusRepository.findById(id);

        if(selectedProjectStatus.isPresent()) {
            ProjectStatus project = selectedProjectStatus.get();

            projectStatusRepository.delete(project);
        } else {
            throw new Exception();
        }
    }
}