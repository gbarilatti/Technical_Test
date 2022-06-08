package com.chalenge.moby.services;

import com.chalenge.moby.exceptions.CandidateAlreadyExistsException;
import com.chalenge.moby.exceptions.TechnologyNotFoundException;
import com.chalenge.moby.models.entities.Candidate;
import com.chalenge.moby.models.entities.CandidateByTechnology;
import com.chalenge.moby.models.entities.Technology;
import com.chalenge.moby.models.views.CandidateByTechnologyDto;
import com.chalenge.moby.models.views.CandidateDto;
import com.chalenge.moby.models.views.TechnologyDto;
import com.chalenge.moby.projections.CandidateByTechnologyProjection;
import com.chalenge.moby.repositories.CandidateByTechnologyRepository;
import com.chalenge.moby.services.imp.CandidateByTechnologyServiceImp;
import static com.chalenge.moby.utils.TestUtils.getCandidate;
import static com.chalenge.moby.utils.TestUtils.getCandidateByTechnology;
import static com.chalenge.moby.utils.TestUtils.getCandidateByTechnologyDto;
import static com.chalenge.moby.utils.TestUtils.getCandidateByTechnologyList;
import static com.chalenge.moby.utils.TestUtils.getCandidateDto;
import static com.chalenge.moby.utils.TestUtils.getCandidateList;
import static com.chalenge.moby.utils.TestUtils.getTechnology;
import static com.chalenge.moby.utils.TestUtils.getTechnologyDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class CandidateByTechnologyServiceImpTest extends AbstractMvcTestServices {

    @InjectMocks
    CandidateByTechnologyServiceImp candidateByTechnologyServiceImp;

    @Mock
    CandidateByTechnologyRepository candidateByTechnologyRepository;

    @Test
    void findAll() {
        List<CandidateByTechnology> candidateByTechnologies = new ArrayList<>();
        when(candidateByTechnologyRepository.findAll()).thenReturn(candidateByTechnologies);
        List<CandidateByTechnology> result = candidateByTechnologyServiceImp.findAll();
        verify(candidateByTechnologyRepository, times(1)).findAll();
        assertEquals(candidateByTechnologyRepository.findAll(), result);
    }

    @Test
    void createTest() {
        CandidateByTechnologyDto candidateByTechnologyDto = getCandidateByTechnologyDto();
        assertTrue(candidateByTechnologyServiceImp.create(candidateByTechnologyDto));
    }

    @Nested
    class UploadCandidateByTechnologyTest {

        @Test
        void uploadCandidateByTechnologyTest() {
            List<CandidateByTechnology> candidateByTechnologies = new ArrayList<>();
            CandidateByTechnologyDto candidateByTechnologyDto = getCandidateByTechnologyDto();
            when(candidateByTechnologyRepository.findAll()).thenReturn(candidateByTechnologies);
            assertTrue(candidateByTechnologyServiceImp.uploadCandidateByTechnology(candidateByTechnologyDto));

        }

        @Test
        void uploadCandidateByTechnologyAlreadyExistsExceptionTest() {
            CandidateByTechnology candidateByTechnology = getCandidateByTechnology();
            Candidate candidate = getCandidate();
            Technology technology = getTechnology();
            CandidateByTechnologyDto candidateByTechnologyDto = getCandidateByTechnologyDto();
            when(candidateByTechnologyRepository.findByCandidateIdAndTechnologyId(candidate.getId(), technology.getId())).thenReturn(candidateByTechnology);
            assertThrows(CandidateAlreadyExistsException.class, () -> candidateByTechnologyServiceImp.uploadCandidateByTechnology(candidateByTechnologyDto));

        }
    }

    @Nested
    class FindById {

        @Test
        void findById() {
            CandidateByTechnology candidateByTechnology = getCandidateByTechnology();
            when(candidateByTechnologyRepository.findById(anyLong())).thenReturn(Optional.ofNullable(candidateByTechnology));
            assertEquals(candidateByTechnologyServiceImp.findById(getCandidateByTechnology().getId()), candidateByTechnology);
        }

        @Test
        void findByIdNotFoundExceptionTest() {
            CandidateByTechnology candidateByTechnology = new CandidateByTechnology();
            Long id = candidateByTechnology.getId();
            assertThrows(TechnologyNotFoundException.class, () -> candidateByTechnologyServiceImp.findById(id));
        }
    }

    @Test
    void findByTechnologyName() {
        List<CandidateByTechnologyProjection> candidateByTechnologyProjections = new ArrayList<>();
        when(candidateByTechnologyRepository.findByTechnologyName(getTechnology().getName())).thenReturn(candidateByTechnologyProjections);
        assertEquals(candidateByTechnologyServiceImp.findByTechnologyName(getTechnology().getName()), candidateByTechnologyProjections);

    }

    @Test
    void findByTechnologyNameAndVersion() {
        List<CandidateByTechnologyProjection> candidateByTechnologyProjections = new ArrayList<>();
        Technology technology = getTechnology();
        when(candidateByTechnologyRepository.findByTechnologyNameAndVersion(technology.getName(), technology.getVersion())).thenReturn(candidateByTechnologyProjections);
        assertEquals(candidateByTechnologyServiceImp.findByTechnologyNameAndVersion(technology.getName(), technology.getVersion()), candidateByTechnologyProjections);

    }
}