package com.chalenge.moby.services;

import com.chalenge.moby.exceptions.TechnologyAlreadyExistsException;
import com.chalenge.moby.exceptions.TechnologyNotFoundException;
import com.chalenge.moby.models.entities.Technology;
import com.chalenge.moby.models.views.TechnologyDto;
import com.chalenge.moby.repositories.TechnologyRepository;
import com.chalenge.moby.services.imp.TechnologyServiceImp;
import static com.chalenge.moby.utils.TestUtils.getTechnology;
import static com.chalenge.moby.utils.TestUtils.getTechnologyDto;
import static org.junit.jupiter.api.Assertions.*;
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

class TechnologyServiceImpTest extends AbstractMvcTestServices {

    @InjectMocks
    TechnologyServiceImp technologyServiceImp;

    @Mock
    TechnologyRepository technologyRepository;

    @Test
    void findAll() {
        List<Technology> technologies = new ArrayList<>();
        when(technologyRepository.findAll()).thenReturn(technologies);

        List<Technology> result = technologyServiceImp.findAll();
        verify(technologyRepository, times(1)).findAll();
        assertEquals(technologyServiceImp.findAll(), result);
    }

    @Test
    void create() {
        TechnologyDto technologyDto = getTechnologyDto();
        assertTrue(technologyServiceImp.create(technologyDto));
    }

    @Nested
    class UploadTechnologyTest {

        @Test
        void uploadTechnologyTest() {
            List<Technology> technologies = new ArrayList<>();
            TechnologyDto technologyDto = getTechnologyDto();
            when(technologyRepository.findAll()).thenReturn(technologies);
            assertTrue(technologyServiceImp.uploadTechnology(technologyDto));

        }

        @Test
        void uploadTechnologyAlreadyExistsExceptionTest() {
            Technology technology = getTechnology();
            TechnologyDto technologyDto = getTechnologyDto();
            when(technologyRepository.findByNameAndVersion(technologyDto.getName(), technologyDto.getVersion())).thenReturn(technology);
            assertThrows(TechnologyAlreadyExistsException.class, () -> technologyServiceImp.uploadTechnology(technologyDto));

        }
    }

    @Nested
    class DeleteByIdTest {

        @Test
        void deleteById() {
            when(technologyRepository.findById(1L)).thenReturn(Optional.of(getTechnology()));
            technologyServiceImp.deleteById(1L);
            verify(technologyRepository, times(1)).deleteById(1L);
        }

        @Test
        void deleteByIdNotFoundExceptionTest() {
            assertThrows(TechnologyNotFoundException.class, () -> technologyServiceImp.deleteById(3L));
        }
    }

    @Nested
    class FindById {

        @Test
        void findById() {
            Technology technology = getTechnology();
            when(technologyRepository.findById(anyLong())).thenReturn(Optional.ofNullable(technology));
            assertEquals(technologyServiceImp.findById(getTechnology().getId()), technology);
        }

        @Test
        void findByIdNotFoundExceptionTest(){
            assertThrows(TechnologyNotFoundException.class, ()->technologyServiceImp.findById(2L));
        }
    }


}