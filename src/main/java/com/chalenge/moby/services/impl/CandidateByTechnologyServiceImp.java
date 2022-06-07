package com.chalenge.moby.services.impl;

import com.chalenge.moby.exceptions.CandidateAlreadyExistsException;
import com.chalenge.moby.exceptions.TechnologyNotFoundException;
import com.chalenge.moby.models.entities.Candidate;
import com.chalenge.moby.models.entities.CandidateByTechnology;
import com.chalenge.moby.models.entities.Technology;
import com.chalenge.moby.models.views.CandidateByTechnologyDto;
import com.chalenge.moby.models.views.CandidateDto;
import com.chalenge.moby.models.views.TechnologyDto;
import com.chalenge.moby.repositories.CandidateByTechnologyRepository;
import com.chalenge.moby.services.CandidateByTechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateByTechnologyServiceImp implements CandidateByTechnologyService {

    @Autowired
    private CandidateByTechnologyRepository candidateByTechnologyRepository;

    public List<CandidateByTechnology> findAll() {
        return candidateByTechnologyRepository.findAll();
    }

    public void create(CandidateDto candidateDto, TechnologyDto technologyDto) {
        uploadCandidateByTechnology(candidateDto, technologyDto);
    }

    public void uploadCandidateByTechnology(CandidateDto candidateDto, TechnologyDto technologyDto) {
        if (candidateByTechnologyRepository.findByCandidateIdAndTechnologyId(candidateDto.getId(), technologyDto.getId()) == null) {
            throw new CandidateAlreadyExistsException("Already exists");
        } else {
            Candidate candidate = Candidate.builder()
                    .name(candidateDto.getName())
                    .lastName(candidateDto.getLastName())
                    .documentType(candidateDto.getDocumentType())
                    .document(candidateDto.getDocument())
                    .birthday(candidateDto.getBirthday())
                    .build();
            Technology technology = Technology.builder()
                    .name(technologyDto.getName())
                    .version(technologyDto.getVersion())
                    .build();
            candidateByTechnologyRepository.save(
                    CandidateByTechnology.builder()
                            .candidate(candidate)
                            .technology(technology)
                            .build()
            );
        }
    }

    public CandidateByTechnology findById(Long candidateByTechnologyId) {
        CandidateByTechnology candidateByTechnology;
        Optional<CandidateByTechnology> candidateByTechnologyOpt = candidateByTechnologyRepository.findById(candidateByTechnologyId);
        if (candidateByTechnologyOpt.isPresent()) {
            candidateByTechnology = candidateByTechnologyOpt.get();
        } else {
            throw new TechnologyNotFoundException("Not exists this candidateByTechnology ");
        }
        return candidateByTechnology;
    }

    public List<CandidateByTechnologyDto> findCandidateByTechnologyName(String name){
        List<CandidateByTechnology> candidateByTechnologies = candidateByTechnologyRepository.findCandidatesByTechnologyName(name);
        List<CandidateByTechnologyDto> candidateByTechnologyDtoList = new ArrayList<>();
        candidateByTechnologies.forEach(candidateByTechnology -> {
            CandidateByTechnologyDto candidateByTechnologyDto = CandidateByTechnologyDto.builder()
                    .candidateName(candidateByTechnology.getCandidate().getName())
                    .experienceYears(candidateByTechnology.getExperienceYears())
                    .build();
            candidateByTechnologyDtoList.add(candidateByTechnologyDto);
        });
        return candidateByTechnologyDtoList;
    }

}
