package com.github.alllef.brokerfirmservice.dto;


import com.github.alllef.brokerfirmservice.entity.person.Client;
import lombok.Data;

@Data
public class FlatRequestDto {
    private final FlatRequest flatRequest;
    private final Client client;
}
