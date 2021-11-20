package com.github.alllef.brokerfirmservice.controller;

import com.github.alllef.brokerfirmservice.entity.person.Client;
import com.github.alllef.brokerfirmservice.repository.ClientRepo;
import com.github.alllef.brokerfirmservice.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public List<Client> getAll() {
        return clientService.getClients();
    }

    @PostMapping
    public void createClient(@RequestBody Client client) {
        clientService.saveClient(client);
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @PutMapping("/{id}")
    void updateClient(@PathVariable Long id, @RequestBody Client client) {
        clientService.saveClient(client);
    }

    @DeleteMapping("/{id}")
    void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
