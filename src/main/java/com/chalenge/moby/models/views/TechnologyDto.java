package com.chalenge.moby.models.views;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TechnologyDto {
    private Long id;
    private String name;
    private String version;
}
