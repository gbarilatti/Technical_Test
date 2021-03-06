package com.chalenge.moby.utils;

import com.chalenge.moby.models.entities.Candidate;
import com.chalenge.moby.models.entities.CandidateByTechnology;
import com.chalenge.moby.models.entities.Technology;
import com.chalenge.moby.models.enums.DocumentType;
import com.chalenge.moby.models.views.CandidateByTechnologyDto;
import com.chalenge.moby.models.views.CandidateDto;
import com.chalenge.moby.models.views.TechnologyDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static Candidate getCandidate() {
        return Candidate.builder()
                .id(1L)
                .name("jose")
                .lastName("perez")
                .documentType(DocumentType.DNI)
                .document("1523564")
                .birthday(null)
                .build();
    }

    public static List<Candidate> getCandidateList() {
        List<Candidate> candidates = new ArrayList<>();
        candidates.add(getCandidate());
        return candidates;
    }

    public static CandidateDto getCandidateDto() {
        return CandidateDto.builder()
                .id(1L)
                .name("jose")
                .lastName("perez")
                .documentType(DocumentType.DNI)
                .document("1523564")
                .birthday(null)
                .build();
    }

    public static Technology getTechnology() {
        return Technology.builder()
                .id(1L)
                .name("superCode")
                .version("0.99")
                .build();
    }

    public static TechnologyDto getTechnologyDto() {
        return TechnologyDto.builder()
                .id(1L)
                .name("superCode")
                .version("0.99")
                .build();
    }

    public static List<Technology> getTechnologyList() {
        List<Technology> technologies = new ArrayList<>();
        technologies.add(getTechnology());
        return technologies;
    }

    public static CandidateByTechnology getCandidateByTechnology() {
        Candidate candidate = getCandidate();
        Technology technology = getTechnology();
        return CandidateByTechnology.builder()
                .id(1L)
                .candidate(candidate)
                .technology(technology)
                .experienceYears(1)
                .build();
    }

    public static CandidateByTechnologyDto getCandidateByTechnologyDto() {
        Candidate candidate = getCandidate();
        Technology technology = getTechnology();
        return CandidateByTechnologyDto.builder()
                .candidate(candidate)
                .technology(technology)
                .experienceYears(1)
                .build();
    }

    public static List<CandidateByTechnology> getCandidateByTechnologyList() {
        List<CandidateByTechnology> candidateByTechnologies = new ArrayList<>();
        candidateByTechnologies.add(getCandidateByTechnology());
        return candidateByTechnologies;
    }
}
