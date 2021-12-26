package com.github.alllef.brokerfirmservice.cache;

import com.github.alllef.brokerfirmservice.dto.FlatRequestDto;
import com.github.alllef.brokerfirmservice.entity.FlatRequest;
import com.github.alllef.brokerfirmservice.entity.FlatRequestCache;
import com.github.alllef.brokerfirmservice.entity.person.Client;
import com.github.alllef.brokerfirmservice.repository.FlatRequestCacheRepo;
import com.github.alllef.brokerfirmservice.service.RequestPerformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CacheService {
    private final RequestPerformer requestPerformer;
    private final FlatRequestCacheRepo flatRequestCacheRepo;


    private void cacheData() {
        flatRequestCacheRepo.deleteAll();

        List<FlatRequestDto> allFilteredFlatRequests = requestPerformer.getAllFilteredFlatRequests();
        List<FlatRequest> allUnfilteredFlatRequests = requestPerformer.getAllUnfilteredFlatRequests();
        List<FlatRequestDto> allUnfilteredFlatRequestsWithUsers = new ArrayList<>();

        for (FlatRequest flatRequest : allUnfilteredFlatRequests) {
            Client client = requestPerformer.getRequestClientById(flatRequest.getClientId());
            allUnfilteredFlatRequestsWithUsers.add(new FlatRequestDto(flatRequest, client));
        }

        allFilteredFlatRequests.addAll(allUnfilteredFlatRequestsWithUsers);
        List<FlatRequestCache> allFlatRequestsCache = new ArrayList<>();

        for (FlatRequestDto flatRequestDto : allFilteredFlatRequests)
            allFlatRequestsCache.add(FlatRequestCache.fromFlatRequestDto(flatRequestDto));

        flatRequestCacheRepo.saveAll(allFlatRequestsCache);
    }

    public List<FlatRequestCache> getFlatRequests() {
        return flatRequestCacheRepo.findAll();
    }
}
