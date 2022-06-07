package com.chalenge.moby.repositories;

import com.chalenge.moby.models.entities.CandidateByTechnology;
import static com.chalenge.moby.utils.Query.FIND_BY_CANDIDATEID_AND_TECHNOLOGYID;
import static com.chalenge.moby.utils.Query.FIND_CANDIDATE_BY_TECHNOLOGYNAME;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateByTechnologyRepository extends JpaRepository<CandidateByTechnology, Long> {

    @Query(value = FIND_BY_CANDIDATEID_AND_TECHNOLOGYID,nativeQuery = true)
    CandidateByTechnology findByCandidateIdAndTechnologyId(Long candidateId, Long technologyId);

    @Query(value = FIND_CANDIDATE_BY_TECHNOLOGYNAME,nativeQuery = true)
    List<CandidateByTechnology> findCandidatesByTechnologyName(String name);
}
