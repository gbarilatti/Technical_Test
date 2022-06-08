package com.chalenge.moby.services.imp;

import com.chalenge.moby.models.entities.CandidateByTechnology;
import com.chalenge.moby.models.views.CandidateByTechnologyDto;
import com.chalenge.moby.projections.CandidateByTechnologyProjection;

import java.util.List;

public interface CandidateByTechnologyService {
    List<CandidateByTechnology> findAll();

    void create(CandidateByTechnologyDto candidateByTechnologyDto);

    void uploadCandidateByTechnology(CandidateByTechnologyDto candidateByTechnologyDto);

    CandidateByTechnology findById(Long candidateByTechnologyId);

    List<CandidateByTechnologyProjection> findByTechnologyName(String technologyName);

    List<CandidateByTechnologyProjection> findByTechnologyNameAndVersion(String technologyName, String technologyVersion);


}
