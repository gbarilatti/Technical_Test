package com.chalenge.moby.controllers;

import com.chalenge.moby.models.entities.CandidateByTechnology;
import com.chalenge.moby.models.entities.Technology;
import com.chalenge.moby.models.views.CandidateByTechnologyDto;
import com.chalenge.moby.models.views.TechnologyDto;
import com.chalenge.moby.services.CandidateByTechnologyService;
import static com.chalenge.moby.utils.TestUtils.getCandidateByTechnology;
import static com.chalenge.moby.utils.TestUtils.getCandidateByTechnologyDto;
import static com.chalenge.moby.utils.TestUtils.getCandidateByTechnologyList;
import static com.chalenge.moby.utils.TestUtils.getTechnology;
import static com.chalenge.moby.utils.TestUtils.getTechnologyDto;
import static com.chalenge.moby.utils.TestUtils.getTechnologyList;
import com.google.gson.Gson;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

class CandidateByTechnologyControllerTest extends AbstractMVCTest {

    @MockBean
    CandidateByTechnologyService candidateByTechnologyService;

    @Test
    void finAllTest() throws Exception {
        List<CandidateByTechnology> candidateByTechnologies = getCandidateByTechnologyList();
        when(candidateByTechnologyService.findAll()).thenReturn(candidateByTechnologies);
        mockMvc.perform(get("/api/candidateByTechnology/").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void createTest() throws Exception {
        CandidateByTechnologyDto candidateByTechnologyDto = getCandidateByTechnologyDto();
        when(candidateByTechnologyService.create(candidateByTechnologyDto)).thenReturn(true);
        String candidateByTechnologyJson = new Gson().toJson(candidateByTechnologyDto);
        mockMvc.perform(post("/api/candidateByTechnology/create").contentType(MediaType.APPLICATION_JSON).content(candidateByTechnologyJson)).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void findByIdTest() throws Exception {
        mockMvc.perform(get("/api/candidateByTechnology/{candidateByTechnologyId}", getCandidateByTechnology().getId())).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void findByTechnologyName() throws Exception {
        mockMvc.perform(get("/api/candidateByTechnology/candidateByTechnologyName/{technologyName}", getTechnology().getName())).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void findByTechnologyNameAndVersion() throws Exception {
        mockMvc.perform(get("/api/candidateByTechnology/candidateByTechnologyName/{technologyName}/{technologyVersion}", getTechnology().getName(), getTechnology().getVersion())).andExpect(MockMvcResultMatchers.status().isOk());
    }
}