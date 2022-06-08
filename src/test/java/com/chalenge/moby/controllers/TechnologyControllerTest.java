package com.chalenge.moby.controllers;

import com.chalenge.moby.models.entities.Candidate;
import com.chalenge.moby.models.entities.Technology;
import com.chalenge.moby.models.views.CandidateDto;
import com.chalenge.moby.models.views.TechnologyDto;
import com.chalenge.moby.services.TechnologyService;
import static com.chalenge.moby.utils.TestUtils.getCandidate;
import static com.chalenge.moby.utils.TestUtils.getCandidateDto;
import static com.chalenge.moby.utils.TestUtils.getTechnology;
import static com.chalenge.moby.utils.TestUtils.getTechnologyDto;
import static com.chalenge.moby.utils.TestUtils.getTechnologyList;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import static org.springframework.http.ResponseEntity.status;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Optional;

class TechnologyControllerTest extends AbstractMVCTest {

    @MockBean
    TechnologyService technologyService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void findAllTest() throws Exception {
        List<Technology> technologies = getTechnologyList();
        when(technologyService.findAll()).thenReturn(technologies);
        mockMvc.perform(get("/api/technology/").contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void createTest() throws Exception {
        TechnologyDto technologyDto = getTechnologyDto();
        when(technologyService.create(technologyDto)).thenReturn(true);
        String technologyDtoJson = new Gson().toJson(technologyDto);
        mockMvc.perform(post("/api/technology/create").contentType(MediaType.APPLICATION_JSON).content(technologyDtoJson)).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete("/api/technology/delete/{technologyId}", getTechnologyDto().getId()).contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isAccepted());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/api/technology/{technologyId}", getTechnology().getId())).andExpect(MockMvcResultMatchers.status().isOk());
    }
}