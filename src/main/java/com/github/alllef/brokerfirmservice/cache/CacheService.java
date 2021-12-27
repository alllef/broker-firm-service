package com.github.alllef.brokerfirmservice.cache;

import com.github.alllef.brokerfirmservice.dto.FlatRequestDto;
import com.github.alllef.brokerfirmservice.entity.FlatRequest;
import com.github.alllef.brokerfirmservice.entity.FlatRequestCache;
import com.github.alllef.brokerfirmservice.entity.person.Client;
import com.github.alllef.brokerfirmservice.repository.ClientRepo;
import com.github.alllef.brokerfirmservice.repository.FlatRequestCacheRepo;
import com.github.alllef.brokerfirmservice.repository.FlatRequestRepo;
import com.github.alllef.brokerfirmservice.service.RequestPerformer;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CacheService {
    private final RequestPerformer requestPerformer;
    private final FlatRequestCacheRepo flatRequestCacheRepo;
    private final FlatRequestRepo flatRequestRepo;
    private final ClientRepo clientRepo;

    @EventListener(ApplicationReadyEvent.class)
    @Order(2)
    public void cacheData() {
        flatRequestCacheRepo.deleteAll();

        List<FlatRequestDto> allFilteredFlatRequests = requestPerformer.getAllFilteredFlatRequests();
        List<FlatRequest> allUnfilteredFlatRequests = requestPerformer.getAllUnfilteredFlatRequestsPageable(5000);
        List<FlatRequest> brokerFirmFlatRequests = flatRequestRepo.findAll();

        List<FlatRequestDto> allUnfilteredFlatRequestsWithUsers = new ArrayList<>();

        List<FlatRequestCache> brokerFirmFlatRequestsWithUsers = brokerFirmFlatRequests.stream()
                .map(flatRequest -> new FlatRequestDto(flatRequest, clientRepo.findById(flatRequest.getClientId()).orElseThrow()))
                .map(FlatRequestCache::fromFlatRequestDto)
                .collect(Collectors.toList());

        for (FlatRequest flatRequest : allUnfilteredFlatRequests) {
            Client client = requestPerformer.getRequestClientById(flatRequest.getClientId());
            allUnfilteredFlatRequestsWithUsers.add(new FlatRequestDto(flatRequest, client));
        }

        allFilteredFlatRequests.addAll(allUnfilteredFlatRequestsWithUsers);

        List<FlatRequestCache> allFlatRequestsCache = allFilteredFlatRequests.stream()
                .map(FlatRequestCache::fromFlatRequestDto)
                .collect(Collectors.toList());

        allFlatRequestsCache.addAll(brokerFirmFlatRequestsWithUsers);

        flatRequestCacheRepo.saveAll(allFlatRequestsCache);
    }

    public List<FlatRequestCache> getFlatRequests() {
        return flatRequestCacheRepo.findAll();
    }
}
