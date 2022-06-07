package com.chalenge.moby.projections;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.Date;

public interface CandidateByTechnologyProjection {
    @Value("#{target.candidate_name}")
    String getName();

    @Value("#{target.candidate_name}")
    String setName(String name);


    @Value("#{target.last_name}")
    String getLastname();

    @Value("#{target.last_name}")
    void setLastname(String lastName);


    @Value("#{target.document}")
    Long getDocument();

    @Value("#{target.document}")
    void setDocument(Long document);


    @Value("#{target.birthday}")
    Date getBirthdate();

    @Value("#{target.birthday}")
    void setBirthdate(LocalDate birthday);


    @Value("#{target.technology_name}")
    String getDescription();

    @Value("#{target.technology_name}")
    void setDescription(String technologyName);


    @Value("#{target.version}")
    void setVersion(String version);

    @Value("#{target.version}")
    String getVersion();


    @Value("#{target.experience_years}")
    void setExperienceYears(Integer experienceYears);

    @Value("#{target.experience_years}")
    Integer getExperienceYears();
}
