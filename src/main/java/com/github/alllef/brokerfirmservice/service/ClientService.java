package com.github.alllef.brokerfirmservice.service;

import com.github.alllef.brokerfirmservice.entity.Flat;
import com.github.alllef.brokerfirmservice.entity.person.Client;
import com.github.alllef.brokerfirmservice.pattern.mediator.FlatCreatedEvent;
import com.github.alllef.brokerfirmservice.repository.ClientRepo;
import com.github.alllef.brokerfirmservice.repository.FlatRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepo clientRepo;
    private final FlatRepo flatRepo;
    private final FlatCreatedEvent flatCreatedEvent;

    public void saveClient(Client client) {
        clientRepo.save(client);
    }

    @Transactional
    public void createFlat(Flat flat) {
        flatRepo.save(flat);
        flatCreatedEvent.onFlatCreated(flat);
    }

    @Transactional
    public void updateFlat(Flat flat) {
        flatRepo.save(flat);
    }

    @Transactional
    public void deleteFlat(Long flatId) {
        flatRepo.deleteById(flatId);
    }

    public Client getClient(Long clientId) {
        return clientRepo.findById(clientId)
                .orElseThrow();
    }

    public List<Client> getClients(){
        return clientRepo.findAll();
    }

    public void deleteClient(Long clientId){
        clientRepo.deleteById(clientId);
    }
}
