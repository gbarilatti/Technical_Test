package com.chalenge.moby.services;

import com.chalenge.moby.models.entities.Technology;
import com.chalenge.moby.models.views.CandidateDto;
import com.chalenge.moby.models.views.TechnologyDto;

import java.util.List;

public interface TechnologyService {

    List<Technology> findAll();

    Boolean create(TechnologyDto technologyDto);

    Boolean uploadTechnology(TechnologyDto technologyDto);

    Boolean deleteById(Long technologyId);

    Technology findById(Long technologyId);

}
