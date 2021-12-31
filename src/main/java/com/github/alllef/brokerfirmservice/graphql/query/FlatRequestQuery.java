package com.github.alllef.brokerfirmservice.graphql.query;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.github.alllef.brokerfirmservice.entity.Flat;
import com.github.alllef.brokerfirmservice.entity.FlatRequest;
import com.github.alllef.brokerfirmservice.entity.FlatRequestCache;
import com.github.alllef.brokerfirmservice.repository.FlatRequestRepo;
import com.github.alllef.brokerfirmservice.service.BrokerService;
import com.github.alllef.brokerfirmservice.service.FlatRequestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FlatRequestQuery implements GraphQLQueryResolver {
    private final FlatRequestService flatRequestService;
    private final BrokerService brokerService;

    public FlatRequest getFlatRequest(long id) {
        return flatRequestService.getFlatRequest(id);
    }

    public List<FlatRequestCache> getFiltered(long flatId) {
        return brokerService.getFlatRequests(flatId);
    }
}
