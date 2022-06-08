package com.chalenge.moby.services.imp;

import com.chalenge.moby.exceptions.CandidateAlreadyExistsException;
import com.chalenge.moby.exceptions.CandidateNotExistsException;
import com.chalenge.moby.models.entities.Candidate;
import com.chalenge.moby.models.views.CandidateDto;
import com.chalenge.moby.repositories.CandidateRepository;
import com.chalenge.moby.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CandidateServiceImp implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    @Override
    @Transactional
    public Boolean create(CandidateDto candidateDto) throws CandidateAlreadyExistsException {
        return uploadCandidate(candidateDto);
    }

    @Override
    public Boolean uploadCandidate(CandidateDto candidateDto) throws CandidateAlreadyExistsException {
        List<Candidate> candidateList = candidateRepository.findAll();
        if (candidateList.stream().anyMatch(candidate -> candidate.getDocument().equals(candidateDto.getDocument()))) {
            throw new CandidateAlreadyExistsException("Candidate " + candidateDto.getDocument() + " already exists");
        } else {
            Candidate candidate = Candidate.builder()
                    .name(candidateDto.getName())
                    .lastName(candidateDto.getLastName())
                    .documentType(candidateDto.getDocumentType())
                    .document(candidateDto.getDocument())
                    .birthday(candidateDto.getBirthday())
                    .build();
            candidateRepository.save(candidate);
        }
        return true;
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        if (candidateRepository.findById(id).isPresent()) {
            candidateRepository.deleteById(id);
        } else {
            throw new CandidateNotExistsException("Candidate " + id + " doesn't exists");
        }

    }

    public Candidate findByDocument(String candidateDocument) {
        Candidate candidate;
        if (candidateRepository.findByDocument(candidateDocument) != null) {
            candidate = candidateRepository.findByDocument(candidateDocument);
        } else {
            throw new CandidateNotExistsException("Candidate with document " + candidateDocument + " doesn't exists");
        }
        return candidate;
    }
}
