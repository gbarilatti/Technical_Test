package com.chalenge.moby.repositories;

import com.chalenge.moby.models.entities.Candidate;
import static com.chalenge.moby.utils.Query.FIND_CANDIDATE_BY_DOCUMENT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    @Query(value = FIND_CANDIDATE_BY_DOCUMENT, nativeQuery = true)
    Candidate findByDocument(String candidateDocument);
}
