package com.example.challenger.data.dao;

import com.example.challenger.data.domain.ProjectStatus;

public interface ProjectStatusDAO {
    ProjectStatus insertProjectStatus(ProjectStatus projectStatus);
    ProjectStatus selectProjectStatus(Long id); // id 값으로 정보찾기
    ProjectStatus selectProjectStatus(String status); // status 값으로 정보찾기
    ProjectStatus updateProjectStatus(ProjectStatus updateProjectStatus) throws Exception;
    void deleteProjectStatus(Long id) throws Exception;

}