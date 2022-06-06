package com.chalenge.moby.models.entities;

import com.chalenge.moby.models.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidates")
public class Candidate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "candidate_id")
    private long id;

    private String name;

    private String lastName;

    private DocumentType documentType;

    private String document;

    private LocalDate birthday;
}
