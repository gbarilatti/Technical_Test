package com.chalenge.moby.services.Impl;

import com.chalenge.moby.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImp {

    @Autowired
    private CandidateRepository candidateRepository;
}
