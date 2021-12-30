package com.github.alllef.brokerfirmservice.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.github.alllef.brokerfirmservice.entity.person.Broker;
import com.github.alllef.brokerfirmservice.service.BrokerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class BrokerQuery implements GraphQLQueryResolver {
    private final BrokerService brokerService;

    public List<Broker> getAll() {
        return brokerService.findAll();
    }

    public Broker getBroker(long id) {
        return brokerService.getBroker(id);
    }
}
