package com.chalenge.moby.repositories;

import com.chalenge.moby.models.entities.Technology;
import static com.chalenge.moby.utils.Query.FIND_TECHNOLOGY_BY_NAME_AND_VERSION;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long> {

    @Query(value = FIND_TECHNOLOGY_BY_NAME_AND_VERSION,nativeQuery = true)
    Technology findByNameAndVersion(String name, String version);
}
