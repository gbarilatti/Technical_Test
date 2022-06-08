package com.chalenge.moby.services.imp;

import com.chalenge.moby.exceptions.CandidateAlreadyExistsException;
import com.chalenge.moby.exceptions.CandidateNotExistsException;
import com.chalenge.moby.models.entities.Candidate;
import com.chalenge.moby.models.views.CandidateDto;
import com.chalenge.moby.repositories.CandidateRepository;

import com.chalenge.moby.services.imp.imp.CandidateServiceImp;
import static com.chalenge.moby.utils.TestUtils.getCandidate;
import static com.chalenge.moby.utils.TestUtils.getCandidateDto;
import static com.chalenge.moby.utils.TestUtils.getCandidateList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class CandidateServiceImpTest extends AbstractMvcTestServices {

    @InjectMocks
    CandidateServiceImp candidateServiceImp;

    @Mock
    CandidateRepository candidateRepository;

    @Test
    void findAll() {
        List<Candidate> candidates = new ArrayList<>();
        when(candidateRepository.findAll()).thenReturn(candidates);

        List<Candidate> result = candidateServiceImp.findAll();
        verify(candidateRepository, times(1)).findAll();
        assertEquals(candidateRepository.findAll(), result);
    }

    @Nested
    class DeleteByIdTest {

        @Test
        void deleteById() {
            when(candidateRepository.findById(1L)).thenReturn(Optional.of(getCandidate()));
            candidateServiceImp.deleteById(1L);
            verify(candidateRepository, times(1)).deleteById(1L);
        }

        @Test
        void deleteByIdNotFoundExceptionTest() {
            assertThrows(CandidateNotExistsException.class, () -> candidateServiceImp.deleteById(3L));
        }
    }

    @Nested
    class FindByDocumentTest {
        @Test
        void findByDocument() {
            Candidate candidate = getCandidate();
            when(candidateRepository.findByDocument(candidate.getDocument())).thenReturn(candidate);
            assertEquals(candidateServiceImp.findByDocument(candidate.getDocument()),candidate);

        }

        @Test
        void findByDocumentNotExistsExceptionTest(){
            assertThrows(CandidateNotExistsException.class, ()-> candidateServiceImp.findByDocument("d"));
        }
    }

    @Nested
    class UploadCandidateTest{

        @Test
        void uploadCandidateTest(){
            List<Candidate> candidates = new ArrayList<>();
            CandidateDto candidateDto = getCandidateDto();
            when(candidateRepository.findAll()).thenReturn(candidates);
            assertTrue(candidateServiceImp.uploadCandidate(candidateDto));

        }

        @Test
        void uploadCandidateAlreadyExistsExceptionTest(){
            List<Candidate> candidates = getCandidateList();
            CandidateDto candidateDto = getCandidateDto();
            when(candidateRepository.findAll()).thenReturn(candidates);
            assertThrows(CandidateAlreadyExistsException.class, ()->candidateServiceImp.uploadCandidate(candidateDto));

        }
    }

    @Test
    void createTest(){
        CandidateDto candidateDto = getCandidateDto();
        assertTrue(candidateServiceImp.create(candidateDto));
    }






}