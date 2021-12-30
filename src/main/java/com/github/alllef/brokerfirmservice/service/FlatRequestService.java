package com.github.alllef.brokerfirmservice.service;

import com.github.alllef.brokerfirmservice.entity.FlatRequest;
import com.github.alllef.brokerfirmservice.repository.FlatRequestRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FlatRequestService {
    private final FlatRequestRepo flatRequestRepo;

    List<FlatRequest> getAllFlatRequests() {
        return flatRequestRepo.findAll();
    }

    FlatRequest getFlatRequest(long id) {
        return flatRequestRepo.findById(id)
                .orElseThrow();
    }

    public void createFlatRequest(FlatRequest flatRequest){
        if (flatRequestRepo.findById(flatRequest.getFlatId()))
    }
}
