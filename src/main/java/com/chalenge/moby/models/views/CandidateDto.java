package com.chalenge.moby.models.views;


import com.chalenge.moby.models.enums.DocumentType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-Arg", timezone = "America/Buenos Aires")
    private LocalDate birthday;

}
