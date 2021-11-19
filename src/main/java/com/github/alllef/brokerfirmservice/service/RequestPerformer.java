package com.github.alllef.brokerfirmservice.service;

import com.github.alllef.brokerfirmservice.dto.FlatRequest;
import com.github.alllef.brokerfirmservice.dto.FlatRequestDto;
import com.github.alllef.brokerfirmservice.entity.Flat;
import com.github.alllef.brokerfirmservice.entity.person.Client;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class RequestPerformer {
    public List<FlatRequestDto> getFilteredFlatRequestsDto(Flat flat) {

        FlatRequestDto[] response = WebClient.builder().baseUrl("http://localhost:8081")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build()
                .post()
                .uri(urlBuilder -> urlBuilder
                        .path("/flat-requests")
                        .queryParam("price", String.valueOf(flat.getPrice()))
                        .queryParam("totalArea", String.valueOf(flat.getTotalArea()))
                        .queryParam("roomsNumber", String.valueOf(flat.getRoomsNumber()))
                        .queryParam("floorNumber", String.valueOf(flat.getFloorNumber()))
                        .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(FlatRequestDto[].class)
                .block();

        return Optional.ofNullable(response)
                .map(res -> Arrays.stream(res).toList())
                .orElse(new ArrayList<>());
    }

    public List<FlatRequest> getAllFlatRequests() {
        FlatRequest[] response = WebClient.builder().baseUrl("http://localhost:8082")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build()
                .post()
                .uri("/flat-requests")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(FlatRequest[].class)
                .block();

        return Optional.ofNullable(response)
                .map(res -> Arrays.stream(res).toList())
                .orElse(new ArrayList<>());
    }

    public Client getRequestClientById(Long clientId) {

        return WebClient.builder().baseUrl("http://localhost:8082")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build()
                .post()
                .uri(urlBuilder -> urlBuilder
                        .path("/flat-requests/{id}")
                        .build(clientId)
                )
                .accept(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                .retrieve()
                .bodyToMono(Client.class)
                .block();
    }
}
