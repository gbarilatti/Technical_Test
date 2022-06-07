package com.chalenge.moby.projections;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.Date;

public interface CandidateByTechnologyProjection {
    @Value("#{target.name}")
    String getName();

    @Value("#{target.name}")
    String setName(String name);


    @Value("#{target.lastname}")
    String getLastname();

    @Value("#{target.lastName}")
    void setLastname(String lastName);


    @Value("#{target.document}")
    Long getDocument();

    @Value("#{target.document}")
    void setDocument(Long document);


    @Value("#{target.birthdate}")
    Date getBirthdate();

    @Value("#{target.birthdate}")
    void setBirthdate(LocalDate birthday);


    @Value("#{target.description}")
    String getDescription();

    @Value("#{target.description}")
    void setDescription(String description);


    @Value("#{target.version}")
    void setVersion(String version);

    @Value("#{target.version}")
    String getVersion();


    @Value("#{target.years_experience}")
    void setExperienceYears(Integer experienceYears);

    @Value("#{target.experienceYears}")
    Integer getExperienceYears();
}
