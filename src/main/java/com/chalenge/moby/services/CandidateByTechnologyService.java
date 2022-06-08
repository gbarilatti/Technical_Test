package com.chalenge.moby.services;

import com.chalenge.moby.models.entities.CandidateByTechnology;
import com.chalenge.moby.models.views.CandidateByTechnologyDto;
import com.chalenge.moby.projections.CandidateByTechnologyProjection;

import java.util.List;

public interface CandidateByTechnologyService {
    List<CandidateByTechnology> findAll();

    Boolean create(CandidateByTechnologyDto candidateByTechnologyDto);

    Boolean uploadCandidateByTechnology(CandidateByTechnologyDto candidateByTechnologyDto);

    CandidateByTechnology findById(Long candidateByTechnologyId);

    List<CandidateByTechnologyProjection> findByTechnologyName(String technologyName);

    List<CandidateByTechnologyProjection> findByTechnologyNameAndVersion(String technologyName, String technologyVersion);


}
