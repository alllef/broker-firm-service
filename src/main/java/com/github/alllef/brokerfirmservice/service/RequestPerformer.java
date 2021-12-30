package com.github.alllef.brokerfirmservice.service;

import com.github.alllef.brokerfirmservice.dto.FlatRequestPageableDto;
import com.github.alllef.brokerfirmservice.dto.FlatRequestTmp;
import com.github.alllef.brokerfirmservice.dto.FlatRequestDto;
import com.github.alllef.brokerfirmservice.entity.Flat;
import com.github.alllef.brokerfirmservice.entity.FlatRequest;
import com.github.alllef.brokerfirmservice.entity.person.Client;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class RequestPerformer {
    private final WebClient webClient;

    public List<FlatRequestDto> getFilteredFlatRequestsDto(Flat flat) {

        FlatRequestDto[] response = webClient
                .get()
                .uri("http://localhost:8081", urlBuilder -> urlBuilder
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

    public List<FlatRequestDto> getAllFilteredFlatRequests() {
        FlatRequestDto[] response = webClient.get()
                .uri("http://localhost:8081", urlBuilder -> urlBuilder
                        .path("/flat-requests")
                        .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(FlatRequestDto[].class)
                .block();

        return Optional.ofNullable(response)
                .map(res -> Arrays.stream(res).collect(Collectors.toList()))
                .orElse(new ArrayList<>());
    }

    private Optional<FlatRequestPageableDto> getUnfilteredFlatRequestsPageable(int page) {
        FlatRequestPageableDto response = webClient.get()
                .uri("http://localhost:8082", uriBuilder -> uriBuilder
                        .path("/flat-requests")
                        .queryParam("page", String.valueOf(page))
                        .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(FlatRequestPageableDto.class)
                .block();

        if (Optional.ofNullable(response).isPresent())
            return Optional.of(response);
        return Optional.empty();
    }

    public List<FlatRequest> getAllUnfilteredFlatRequestsPageable(int pageSize) {
        List<FlatRequest> resultList = new ArrayList<>();
        Optional<FlatRequestPageableDto> flatRequestPageableDto = getUnfilteredFlatRequestsPageable(0);
        if (flatRequestPageableDto.isPresent()) {
            resultList.addAll(flatRequestPageableDto.get().getContent());
            for (int i = 1; i < flatRequestPageableDto.get().getPagesTotal(); i++) {
                FlatRequestPageableDto tmpFlatRequestPageableDto = getUnfilteredFlatRequestsPageable(i).orElseThrow();
                resultList.addAll(tmpFlatRequestPageableDto.getContent());
            }
        }
        return resultList;
    }

    public Client getRequestClientById(Long clientId) {

        return webClient.get()
                .uri("http://localhost:8082", urlBuilder -> urlBuilder
                        .path("/flat-requests/clients/{id}")
                        .build(clientId)
                )
                .accept(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                .retrieve()
                .bodyToMono(Client.class)
                .block();
    }
}
