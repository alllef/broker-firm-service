package com.github.alllef.brokerfirmservice.controller;

import com.github.alllef.brokerfirmservice.entity.Flat;
import com.github.alllef.brokerfirmservice.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/flats")
public class FlatController {
    private final ClientService clientService;

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
}
