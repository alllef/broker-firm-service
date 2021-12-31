package com.github.alllef.brokerfirmservice.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.github.alllef.brokerfirmservice.entity.Flat;
import com.github.alllef.brokerfirmservice.entity.person.Broker;
import com.github.alllef.brokerfirmservice.service.BrokerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FlatQuery implements GraphQLQueryResolver {
    private final BrokerService brokerService;

    public List<Flat> getAllFlats() {
        return brokerService.findAllFlats();
    }

    public Flat getFlat(long id) {
        return brokerService.getFlat(id);
    }
}
