package com.chalenge.moby.services.Impl;

import com.chalenge.moby.repositories.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnologyServiceImp {

    @Autowired
    private TechnologyRepository technologyRepository;
}
