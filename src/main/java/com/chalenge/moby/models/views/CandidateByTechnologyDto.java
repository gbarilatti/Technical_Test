package com.chalenge.moby.models.views;


import com.chalenge.moby.models.entities.Candidate;
import com.chalenge.moby.models.entities.Technology;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateByTechnologyDto {
    private Candidate candidate;
    private Technology technology;
    private long experienceYears;
}
