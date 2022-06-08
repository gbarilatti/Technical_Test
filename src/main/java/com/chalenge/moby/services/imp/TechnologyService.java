package com.chalenge.moby.services.imp;

import com.chalenge.moby.models.entities.Technology;
import com.chalenge.moby.models.views.TechnologyDto;

import java.util.List;

public interface TechnologyService {

    List<Technology> findAll();

    Boolean create(TechnologyDto technologyDto);

    Boolean uploadTechnology(TechnologyDto technologyDto);

    void deleteById(Long technologyId);

    Technology findById(Long technologyId);

}
