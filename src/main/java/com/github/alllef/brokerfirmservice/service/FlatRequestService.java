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

    public List<FlatRequest> getAllFlatRequests() {
        return flatRequestRepo.findAll();
    }

    public FlatRequest getFlatRequest(long id) {
        return flatRequestRepo.findById(id)
                .orElseThrow();
    }

    public FlatRequest createFlatRequest(FlatRequest flatRequest) {
        if (flatRequest.getFlatRequestId() != null)
            throw new IllegalArgumentException();
        return flatRequestRepo.save(flatRequest);
    }

    public FlatRequest updateFlatRequest(FlatRequest flatRequest) {
        if (flatRequestRepo.findById(flatRequest.getFlatRequestId()).isEmpty())
            throw new IllegalArgumentException();
        return flatRequestRepo.save(flatRequest);
    }

    public void deleteFlatRequest(long id) {
        flatRequestRepo.deleteById(id);
    }
}
