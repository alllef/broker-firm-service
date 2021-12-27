package com.github.alllef.brokerfirmservice.dto;

import com.github.alllef.brokerfirmservice.entity.FlatRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class FlatRequestPageableDto {
    private List<FlatRequest> content;
    private Integer page;
    private Integer pagesTotal;
    private Integer pageSize;
}
