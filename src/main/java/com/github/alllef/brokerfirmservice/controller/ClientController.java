package com.github.alllef.brokerfirmservice.controller;

import com.github.alllef.brokerfirmservice.entity.person.Client;
import com.github.alllef.brokerfirmservice.repository.ClientRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientRepo clientRepo;

    @GetMapping
    public List<Client> getAll() {
        return clientRepo.findAll();
    }

    @PostMapping
    public void createClient(@RequestBody Client client) {
        clientRepo.save(client);
    }

    @GetMapping("/{id}")
    void getClient() {

    }

    @PutMapping("/{id}")
    void updateClient(@PathVariable Long id, @RequestBody Client client) {
        clientRepo.save(client);
    }

    @DeleteMapping("/{id}")
    void deleteClient(@PathVariable Long id) {
        clientRepo.deleteById(id);
    }
}
