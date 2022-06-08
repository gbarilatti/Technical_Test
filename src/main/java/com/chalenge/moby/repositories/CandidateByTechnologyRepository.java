package com.chalenge.moby.repositories;

import com.chalenge.moby.models.entities.CandidateByTechnology;
import com.chalenge.moby.projections.CandidateByTechnologyProjection;
import static com.chalenge.moby.utils.Query.FIND_BY_CANDIDATE_ID_AND_TECHNOLOGY_ID;
import static com.chalenge.moby.utils.Query.FIND_CANDIDATE_BY_TECHNOLOGY_NAME;
import static com.chalenge.moby.utils.Query.FIND_CANDIDATE_BY_TECHNOLOGY_NAME_AND_VERSION;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateByTechnologyRepository extends JpaRepository<CandidateByTechnology, Long> {

    @Query(value = FIND_BY_CANDIDATE_ID_AND_TECHNOLOGY_ID, nativeQuery = true)
    CandidateByTechnology findByCandidateIdAndTechnologyId(Long candidateId, Long technologyId);

    @Query(value = FIND_CANDIDATE_BY_TECHNOLOGY_NAME, nativeQuery = true)
    List<CandidateByTechnologyProjection> findByTechnologyName(String technologyName);

    @Query(value = FIND_CANDIDATE_BY_TECHNOLOGY_NAME_AND_VERSION, nativeQuery = true)
    List<CandidateByTechnologyProjection> findByTechnologyNameAndVersion(String technologyName, String technologyVersion);
}
