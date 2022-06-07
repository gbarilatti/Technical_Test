package com.chalenge.moby.services.impl;

import com.chalenge.moby.exceptions.TechnologyAlreadyExistsException;
import com.chalenge.moby.exceptions.TechnologyNotFoundException;
import com.chalenge.moby.models.entities.Technology;
import com.chalenge.moby.models.views.TechnologyDto;
import com.chalenge.moby.repositories.TechnologyRepository;
import com.chalenge.moby.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnologyServiceImp implements TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;

    @Override
    public List<Technology> findAll() {
        return technologyRepository.findAll();
    }

    @Override
    public Boolean create(TechnologyDto technologyDto) throws TechnologyAlreadyExistsException {
        return uploadTechnology(technologyDto);
    }

    @Override
    public Boolean uploadTechnology(TechnologyDto technologyDto) throws TechnologyAlreadyExistsException {

        if (technologyRepository.findByNameAndVersion(technologyDto.getName(), technologyDto.getVersion()) != null) {
            throw new TechnologyAlreadyExistsException("Technology " + technologyDto.getName()
                    + " version " + technologyDto.getVersion() + " already exists");
        } else {
            Technology technology = Technology.builder()
                    .name(technologyDto.getName())
                    .version(technologyDto.getVersion())
                    .build();
            technologyRepository.save(technology);
        }
        return true;
    }

    @Override
    public Boolean deleteById(Long technologyId) {
        if (technologyRepository.findById(technologyId).isPresent()) {
            technologyRepository.deleteById(technologyId);
        } else {
            throw new TechnologyNotFoundException("Not found technology " + technologyId);
        }
        return true;
    }

    @Override
    public Technology findById(Long technologyId) {
        Technology technology;
        Optional<Technology> technologyOpt = technologyRepository.findById(technologyId);
        if (technologyOpt.isPresent()) {
            technology = technologyOpt.get();
        } else {
            throw new TechnologyNotFoundException("Not found technology " + technologyId);
        }
        return technology;
    }
}
