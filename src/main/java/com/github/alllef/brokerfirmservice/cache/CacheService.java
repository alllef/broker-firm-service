package com.github.alllef.brokerfirmservice.cache;

import com.github.alllef.brokerfirmservice.dto.FlatRequestDto;
import com.github.alllef.brokerfirmservice.entity.FlatRequest;
import com.github.alllef.brokerfirmservice.entity.FlatRequestCache;
import com.github.alllef.brokerfirmservice.repository.ClientRepo;
import com.github.alllef.brokerfirmservice.repository.FlatRequestCacheRepo;
import com.github.alllef.brokerfirmservice.repository.FlatRequestRepo;
import com.github.alllef.brokerfirmservice.service.RequestPerformer;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CacheService {
    private final RequestPerformer requestPerformer;
    private final FlatRequestCacheRepo flatRequestCacheRepo;
    private final FlatRequestRepo flatRequestRepo;
    private final ClientRepo clientRepo;

    @Scheduled(cron = "0 0 9 * * 1-5")
    public void cacheData() {
        flatRequestCacheRepo.deleteAll();

        List<FlatRequest> allFilteredFlatRequests = requestPerformer.getAllFilteredFlatRequests()
                .stream()
                .map(FlatRequestDto::getFlatRequest)
                .collect(Collectors.toList());

        List<FlatRequest> allUnfilteredFlatRequests = requestPerformer.getAllUnfilteredFlatRequestsPageable(5000);
        allFilteredFlatRequests.addAll(allUnfilteredFlatRequests);

        List<FlatRequestCache> cached = allFilteredFlatRequests.stream()
                        .map(FlatRequest::toFlatRequestCache)
                                .collect(Collectors.toList());

                flatRequestCacheRepo.saveAll(cached);
    }

    public List<FlatRequestCache> getFlatRequests() {
        return flatRequestCacheRepo.findAll();
    }
}
