package com.chalenge.moby.controllers;

import com.chalenge.moby.models.entities.Candidate;
import com.chalenge.moby.models.views.CandidateDto;
import com.chalenge.moby.repositories.CandidateRepository;
import com.chalenge.moby.services.CandidateService;
import static com.chalenge.moby.utils.TestUtils.getCandidate;
import static com.chalenge.moby.utils.TestUtils.getCandidateDto;
import static com.chalenge.moby.utils.TestUtils.getCandidateList;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
class CandidateControllerTest extends AbstractMVCTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    CandidateService candidateService;

    @Mock
    CandidateRepository candidateRepository;


    @Test
    void findAllTest() throws Exception {
        List<Candidate> candidateList = getCandidateList();
        when(candidateService.findAll()).thenReturn(candidateList);
        mockMvc.perform(get("/api/candidate/").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void createTest() throws Exception {
        CandidateDto candidateDto = getCandidateDto();
        when(candidateService.create(candidateDto)).thenReturn(true);
        String candidateDtoJson = new Gson().toJson(candidateDto);
        mockMvc.perform(post("/api/candidate/create").contentType(MediaType.APPLICATION_JSON).content(candidateDtoJson)).andExpect(status().isCreated());

    }

    @Test
    void deleteByIdTest() throws Exception{
        mockMvc.perform(delete("/api/candidate/delete/{candidateId}", getCandidate().getId()).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isAccepted());
    }

    @Test
    void findByDocument() throws Exception {
        mockMvc.perform(get("/api/candidate/findByDocument/{candidateDocument}",getCandidate().getDocument())).andExpect(MockMvcResultMatchers.status().isOk());
    }
}