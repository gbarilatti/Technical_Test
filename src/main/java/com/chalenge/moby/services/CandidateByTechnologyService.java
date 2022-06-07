package com.chalenge.moby.services;

import com.chalenge.moby.models.entities.CandidateByTechnology;
import com.chalenge.moby.models.views.CandidateByTechnologyDto;
import com.chalenge.moby.models.views.CandidateDto;
import com.chalenge.moby.models.views.TechnologyDto;

import java.util.List;

public interface CandidateByTechnologyService {
    List<CandidateByTechnology> findAll();

    void create(CandidateDto candidateDto, TechnologyDto technologyDto);

    CandidateByTechnology findById(Long candidateByTechnologyId);

    List<CandidateByTechnologyDto> findCandidateByTechnologyName(String name);

}
