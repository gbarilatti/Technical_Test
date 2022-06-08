package com.chalenge.moby.controllers;

import com.chalenge.moby.models.entities.Candidate;
import com.chalenge.moby.models.views.CandidateDto;
import com.chalenge.moby.services.imp.CandidateService;
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
@RequestMapping(value = "api/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Candidate>> findAll() {
        return ResponseEntity.ok(candidateService.findAll());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Boolean> create(@RequestBody CandidateDto candidateDto) {
        return new ResponseEntity<>(candidateService.create(candidateDto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{candidateId}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long candidateId) {
        candidateService.deleteById(candidateId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/findByDocument/{candidateDocument}")
    public ResponseEntity<Candidate> findByDocument(@PathVariable String candidateDocument) {
        return new ResponseEntity<>(candidateService.findByDocument(candidateDocument), HttpStatus.OK);
    }

}
