package com.github.alllef.brokerfirmservice.service;

import com.github.alllef.brokerfirmservice.entity.Flat;
import com.github.alllef.brokerfirmservice.entity.person.Client;
import com.github.alllef.brokerfirmservice.pattern.mediator.FlatCreatedEvent;
import com.github.alllef.brokerfirmservice.repository.ClientRepo;
import com.github.alllef.brokerfirmservice.repository.FlatRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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
        flatRepo.save(flat);
        flatCreatedEvent.onFlatCreated(flat);
    }

    public void updateFlat(Flat flat) {
        flatRepo.save(flat);
    }

    public void deleteFlat(Long flatId) {
        flatRepo.deleteById(flatId);
    }

}
