package com.github.alllef.brokerfirmservice.pattern.memento;

import com.github.alllef.brokerfirmservice.entity.Flat;
import com.github.alllef.brokerfirmservice.service.BrokerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FlatCreatedEvent {
    private final BrokerService brokerService;

    public void onFlatCreated(Flat flat) {
        brokerService.registerFlat(flat);
    }
}
