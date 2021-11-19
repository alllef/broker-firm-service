package com.github.alllef.brokerfirmservice.controller;

import com.github.alllef.brokerfirmservice.dto.FlatRequest;
import com.github.alllef.brokerfirmservice.entity.Flat;
import com.github.alllef.brokerfirmservice.service.BrokerService;
import com.github.alllef.brokerfirmservice.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/flats")
public class FlatController {
    private final ClientService clientService;
    private final BrokerService brokerService;

    @PostMapping
    public void createFlat(@RequestBody Flat flat) {
        clientService.createFlat(flat);
    }

    @PutMapping("/{id}")
    public void updateFlat(@PathVariable Long id, @RequestBody Flat flat) {
        clientService.updateFlat(flat);
    }

    @DeleteMapping("/{id}")
    public void deleteFlat(@PathVariable Long id) {
        clientService.deleteFlat(id);
    }

    @GetMapping("/{id}/flat-requests")
    public List<FlatRequest> getRequests(@PathVariable Long id) {
        return brokerService.getFlatRequests(id);
    }
}
