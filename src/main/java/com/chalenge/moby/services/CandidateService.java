package com.chalenge.moby.services;

import com.chalenge.moby.models.entities.Candidate;
import com.chalenge.moby.models.enums.DocumentType;
import com.chalenge.moby.models.views.CandidateDto;

import java.util.List;

public interface CandidateService {

    List<Candidate> findAll();

    Boolean create(CandidateDto candidateDto);

    Boolean uploadCandidate(CandidateDto candidateDto);

    void deleteById(long id);

    Candidate findByDocument(String candidateDocument);
}
