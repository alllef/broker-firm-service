package com.github.alllef.brokerfirmservice.pattern.mediator;

import com.github.alllef.brokerfirmservice.service.BrokerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FlatCreatedEvent {
    private final BrokerService brokerService;

    public void onFlatCreated() {
        brokerService.registerFlat();
    }
}
