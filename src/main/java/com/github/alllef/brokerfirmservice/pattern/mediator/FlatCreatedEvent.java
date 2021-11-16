package com.github.alllef.brokerfirmservice.pattern.mediator;

import com.github.alllef.brokerfirmservice.entity.Flat;
import com.github.alllef.brokerfirmservice.service.BrokerService;
import com.github.alllef.brokerfirmservice.service.CentralDepartment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FlatCreatedEvent {
    private final CentralDepartment centralDepartment;

    public void onFlatCreated(Flat flat) {
       centralDepartment.setBrokerForRequest(flat);
    }
}
