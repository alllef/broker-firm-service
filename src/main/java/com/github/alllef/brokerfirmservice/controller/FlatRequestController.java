package com.github.alllef.brokerfirmservice.controller;

import com.github.alllef.brokerfirmservice.entity.FlatRequest;
import com.github.alllef.brokerfirmservice.entity.person.Client;
import com.github.alllef.brokerfirmservice.repository.FlatRequestRepo;
import com.github.alllef.brokerfirmservice.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flat-requests")
@AllArgsConstructor
public class FlatRequestController {
    private final FlatRequestRepo flatRequestRepo;

    @GetMapping
    public List<FlatRequest> getAll() {
        return flatRequestRepo.findAll();
    }

    @PostMapping
    public void createFlat(@RequestBody FlatRequest flatRequest) {
        flatRequestRepo.save(flatRequest);
    }

    @GetMapping("/{id}")
    public FlatRequest getFlatRequest(@PathVariable Long id) {
        return flatRequestRepo.findById(id)
                .orElseThrow();
    }

    @PutMapping("/{id}")
    void updateClient(@PathVariable Long id, @RequestBody FlatRequest flatRequest) {
        flatRequestRepo.save(flatRequest);
    }

    @DeleteMapping("/{id}")
    void deleteClient(@PathVariable Long id)
    {
        flatRequestRepo.deleteById(id);
    }
}
