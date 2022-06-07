package com.chalenge.moby.repositories;

import com.chalenge.moby.models.entities.CandidateByTechnology;
import static com.chalenge.moby.utils.Query.FIND_BY_CANDIDATEID_AND_TECHNOLOGYID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateByTechnologyRepository extends JpaRepository<CandidateByTechnology, Long> {

    @Query(value = FIND_BY_CANDIDATEID_AND_TECHNOLOGYID,nativeQuery = true)
    CandidateByTechnologyRepository findByCandidateIdAndTechnologyId(Long candidateId, Long technologyId);
}
