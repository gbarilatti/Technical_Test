package com.chalenge.moby.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidate_x_technology")
public class CandidateByTechnology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_x_technology_id")
    private Long id;

    @JoinColumn(name = "candidate_id", referencedColumnName = "candidate_id")
    @ManyToOne
    private Candidate candidate;

    @JoinColumn(name = "technology_id", referencedColumnName = "technology_id")
    @ManyToOne
    private Technology technology;

    private long experienceYear;
}
