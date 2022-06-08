package com.chalenge.moby.services.imp;

import com.chalenge.moby.exceptions.CandidateAlreadyExistsException;
import com.chalenge.moby.exceptions.TechnologyNotFoundException;
import com.chalenge.moby.models.entities.Candidate;
import com.chalenge.moby.models.entities.CandidateByTechnology;
import com.chalenge.moby.models.entities.Technology;
import com.chalenge.moby.models.views.CandidateByTechnologyDto;
import com.chalenge.moby.projections.CandidateByTechnologyProjection;
import com.chalenge.moby.repositories.CandidateByTechnologyRepository;
import com.chalenge.moby.services.CandidateByTechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateByTechnologyServiceImp implements CandidateByTechnologyService {

    @Autowired
    private CandidateByTechnologyRepository candidateByTechnologyRepository;

    @Override
    public List<CandidateByTechnology> findAll() {
        return candidateByTechnologyRepository.findAll();
    }

    @Override
    public Boolean create(CandidateByTechnologyDto candidateByTechnologyDto) {
        return uploadCandidateByTechnology(candidateByTechnologyDto);
    }

    @Override
    public Boolean uploadCandidateByTechnology(CandidateByTechnologyDto candidateByTechnologyDto) {
        if (candidateByTechnologyRepository.findByCandidateIdAndTechnologyId(candidateByTechnologyDto.getCandidate().getId(), candidateByTechnologyDto.getTechnology().getId()) != null) {
            throw new CandidateAlreadyExistsException("Already exists");
        } else {
            Candidate candidate = Candidate.builder()
                    .id(candidateByTechnologyDto.getCandidate().getId())
                    .name(candidateByTechnologyDto.getCandidate().getName())
                    .lastName(candidateByTechnologyDto.getCandidate().getLastName())
                    .documentType(candidateByTechnologyDto.getCandidate().getDocumentType())
                    .document(candidateByTechnologyDto.getCandidate().getDocument())
                    .birthday(candidateByTechnologyDto.getCandidate().getBirthday())
                    .build();
            Technology technology = Technology.builder()
                    .id(candidateByTechnologyDto.getTechnology().getId())
                    .name(candidateByTechnologyDto.getTechnology().getName())
                    .version(candidateByTechnologyDto.getTechnology().getVersion())
                    .build();
            candidateByTechnologyRepository.save(
                    CandidateByTechnology.builder()
                            .candidate(candidate)
                            .technology(technology)
                            .experienceYears(candidateByTechnologyDto.getExperienceYears())
                            .build()
            );
        }
        return true;
    }

    @Override
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

    @Override
    public List<CandidateByTechnologyProjection> findByTechnologyName(String technologyName) {
        return candidateByTechnologyRepository.findByTechnologyName(technologyName);
    }

    @Override
    public List<CandidateByTechnologyProjection> findByTechnologyNameAndVersion(String technologyName, String technologyVersion) {
        return candidateByTechnologyRepository.findByTechnologyNameAndVersion(technologyName, technologyVersion);
    }


}
