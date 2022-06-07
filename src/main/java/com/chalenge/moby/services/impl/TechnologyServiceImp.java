package com.chalenge.moby.services.impl;

import com.chalenge.moby.repositories.TechnologyRepository;
import com.chalenge.moby.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnologyServiceImp implements TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;
}
