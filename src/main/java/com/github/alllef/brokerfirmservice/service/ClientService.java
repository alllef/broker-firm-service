package com.github.alllef.brokerfirmservice.service;

import com.github.alllef.brokerfirmservice.entity.Flat;
import com.github.alllef.brokerfirmservice.entity.person.Client;
import com.github.alllef.brokerfirmservice.pattern.memento.FlatCreatedEvent;
import com.github.alllef.brokerfirmservice.repository.ClientRepo;
import com.github.alllef.brokerfirmservice.repository.FlatRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepo clientRepo;
    private final FlatRepo flatRepo;
    private final FlatCreatedEvent flatCreatedEvent;

    public void saveClient(Client client) {
        clientRepo.save(client);
    }

    public void createFlat(Flat flat) {
        flatRepo.createFlat(flat.getClientId(), flat.getFloorNumber(), flat.getTotalArea(), flat.getPrice(), flat.getRoomsNumber(), flat.getDescription());
        flatCreatedEvent.onFlatCreated(flat);
    }

    public void updateFlat(Flat flat) {
        flatRepo.save(flat);
    }

    public void deleteFlat(Long flatId) {
        flatRepo.deleteById(flatId);
    }
}
