package com.github.alllef.brokerfirmservice.service;

import com.github.alllef.brokerfirmservice.entity.Flat;
import com.github.alllef.brokerfirmservice.entity.person.Client;
import com.github.alllef.brokerfirmservice.repository.ClientRepo;
import com.github.alllef.brokerfirmservice.repository.FlatRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepo clientRepo;
    private final FlatRepo flatRepo;

    public void saveClient(Client client) {
        clientRepo.save(client);
    }

    public void createFlat(Flat flat) {
        flatRepo.save(flat);
    }

}
