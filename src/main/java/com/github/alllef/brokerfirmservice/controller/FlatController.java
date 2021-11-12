package com.github.alllef.brokerfirmservice.controller;

import com.github.alllef.brokerfirmservice.entity.Flat;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/flats")
public class FlatController {

    @GetMapping("/{id}")
    public Flat getFlat(){}

    @PostMapping
    public void createFlat(@RequestBody Flat flat){}

    @PutMapping("/{id}")
    public void updateFlat(){}

    @DeleteMapping("/{id}")
    public void deleteFlat(){}
}
