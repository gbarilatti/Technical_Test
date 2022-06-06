package com.chalenge.moby.models.views;


import com.chalenge.moby.models.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CandidateDto {

    private long id;

    private String name;

    private String lastName;

    private DocumentType documentType;

    private String document;
}
