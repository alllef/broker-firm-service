package com.github.alllef.brokerfirmservice.controller;

import com.github.alllef.brokerfirmservice.entity.person.Client;
import com.github.alllef.brokerfirmservice.repository.ClientRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientRepo clientRepo;

    @GetMapping
    List<Client> getAll() {
        return clientRepo.findAll();
    }
}
