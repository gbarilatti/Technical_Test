package com.chalenge.moby.controllers;

import com.chalenge.moby.models.entities.CandidateByTechnology;
import com.chalenge.moby.models.views.CandidateByTechnologyDto;
import com.chalenge.moby.projections.CandidateByTechnologyProjection;
import com.chalenge.moby.services.CandidateByTechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/candidateByTechnology")
public class CandidateByTechnologyController {

    @Autowired
    private CandidateByTechnologyService candidateByTechnologyService;


    @GetMapping(value = "/")
    public ResponseEntity<List<CandidateByTechnology>> finAll() {
        return ResponseEntity.ok(candidateByTechnologyService.findAll());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Boolean> create(@RequestBody CandidateByTechnologyDto candidateByTechnologyDto) {
        return new ResponseEntity<>(candidateByTechnologyService.create(candidateByTechnologyDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{candidateByTechnologyId}")
    public ResponseEntity<CandidateByTechnology> findById(@PathVariable Long candidateByTechnologyId) {
        return new ResponseEntity<>(candidateByTechnologyService.findById(candidateByTechnologyId), HttpStatus.OK);
    }

    @GetMapping(value = "/candidateByTechnologyName/{technologyName}")
    public ResponseEntity<List<CandidateByTechnologyProjection>> findByTechnologyName(@PathVariable String technologyName) {
        return new ResponseEntity<>(candidateByTechnologyService.findByTechnologyName(technologyName), HttpStatus.OK);
    }

    @GetMapping(value = "/candidateByTechnologyName/{technologyName}/{technologyVersion}")
    public ResponseEntity<List<CandidateByTechnologyProjection>> findByTechnologyNameAndVersion(@PathVariable String technologyName,
                                                                                                @PathVariable String technologyVersion) {
        return new ResponseEntity<>(candidateByTechnologyService.
                findByTechnologyNameAndVersion(technologyName, technologyVersion), HttpStatus.OK);
    }
}
