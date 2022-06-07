package com.chalenge.moby.models.views;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateByTechnologyDto {
    private String candidateName;
    private String candidateLastName;
    private long experienceYears;
}
