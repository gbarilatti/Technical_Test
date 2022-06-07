package com.chalenge.moby.controllers;

import com.chalenge.moby.models.entities.Technology;
import com.chalenge.moby.models.views.CandidateDto;
import com.chalenge.moby.models.views.TechnologyDto;
import com.chalenge.moby.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/technology")
public class TechnologyController {

    @Autowired
    TechnologyService technologyService;

    @RequestMapping(value = "/")
    public ResponseEntity<List<Technology>> findAll() {
        return new ResponseEntity<>(technologyService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Boolean> create(@RequestBody TechnologyDto technologyDto) {
        return new ResponseEntity<>(technologyService.create(technologyDto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{technologyId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long technologyId) {
        return new ResponseEntity<>(technologyService.deleteById(technologyId), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{technologyId}")
    public ResponseEntity<Technology> findById(@PathVariable Long technologyId){
        return ResponseEntity.ok(technologyService.findById(technologyId));
    }
}
