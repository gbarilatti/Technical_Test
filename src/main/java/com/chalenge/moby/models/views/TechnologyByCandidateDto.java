package com.chalenge.moby.models.views;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyByCandidateDto {
    private String name;
    private Integer score;
}
