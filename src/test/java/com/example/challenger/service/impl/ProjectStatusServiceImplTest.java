package com.example.challenger.service.impl;

import com.example.challenger.data.dao.ProjectStatusDAO;
import com.example.challenger.data.domain.ProjectStatus;
import com.example.challenger.data.dto.ProjectStatusDto.ResponseDto;
import com.example.challenger.data.dto.ProjectStatusDto.RequestDto;
import com.example.challenger.data.dto.ProjectStatusDto.UpdateDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class ProjectStatusServiceImplTest {
    @Mock
    private ProjectStatusDAO projectStatusDAO;

    @InjectMocks
    private ProjectStatusServiceImpl projectStatusService;

    @Test
    void getProjectStatus() {
        ProjectStatus pr = new ProjectStatus();
        Long id = 1L;
        pr.setId(1L);
        pr.setStatus("bad");

        when(projectStatusDAO.selectProjectStatus(id)).thenReturn(pr);

        ResponseDto response = projectStatusService.getProjectStatus(id);
        assertThat(response.getId()).isEqualTo(id);
        assertThat(response.getStatus()).isEqualTo(pr.getStatus());

        System.out.println("ID : " + response.getId() + ", Status : " + response.getStatus());
        System.out.println("Test Ok");
    }

    @Test
    void saveProjectStatus() {
        RequestDto request = RequestDto.builder()
                .status("good")
                .build();
        ProjectStatus pr = new ProjectStatus();
        Long id = 1L;
        pr.setId(1L);
        pr.setStatus(request.getStatus());

        when(projectStatusDAO.insertProjectStatus(pr)).thenReturn(pr);
        ProjectStatus savedProjectStatus = pr;

        ResponseDto response = ResponseDto.builder()
                .id(savedProjectStatus.getId())
                .status(savedProjectStatus.getStatus())
                .build();
        assertThat(response.getId()).isEqualTo(id);
        assertThat(response.getStatus()).isEqualTo(pr.getStatus());

        System.out.println("ID : " + response.getId() + ", Status : " + response.getStatus());
        System.out.println("Test Ok");
    }

    @Test
    void updateProjectStatus() throws Exception {
        UpdateDto update = UpdateDto.builder()
                .id(2L)
                .status("not good")
                .build();
        ProjectStatus pr = new ProjectStatus();
        Long id = 2L;
        pr.setId(update.getId());
        pr.setStatus(update.getStatus());

        when(projectStatusDAO.updateProjectStatus(pr)).thenReturn(pr);
        ProjectStatus updateProjectStatus = pr;

        ResponseDto response = ResponseDto.builder()
                .id(updateProjectStatus.getId())
                .status(updateProjectStatus.getStatus())
                .build();
        assertThat(response.getId()).isEqualTo(id);
        assertThat(response.getStatus()).isEqualTo(pr.getStatus());

        System.out.println("ID : " + response.getId() + ", Status : " + response.getStatus());
        System.out.println("Test Ok");
    }
}