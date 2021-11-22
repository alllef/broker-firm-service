package com.github.alllef.brokerfirmservice.controller;

import com.github.alllef.brokerfirmservice.entity.Flat;
import com.github.alllef.brokerfirmservice.entity.PurchaseAgreement;
import com.github.alllef.brokerfirmservice.entity.person.Broker;
import com.github.alllef.brokerfirmservice.service.BrokerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/brokers")
public class BrokerController {
    private final BrokerService brokerService;

    @GetMapping
    public List<Broker> getAll(){
        return brokerService.findAll();
    }

    @GetMapping("/{id}/purchaseAgreements")
    List<PurchaseAgreement> getPurchaseAgreements(@PathVariable Long id) {
        return brokerService.getAgreementsByBrokerId(id);
    }

    @GetMapping("/{id}")
    public Broker getBroker(@PathVariable Long id) {
        return brokerService.getBroker(id);
    }

    @PostMapping
    public void createBroker(@RequestBody Broker broker) {
        brokerService.createBroker(broker);
    }

    @PutMapping("/{id}")
    public void updateBroker(@PathVariable Long id, @RequestBody Broker broker) {
        brokerService.updateBroker(broker);
    }

    @DeleteMapping("/{id}")
    public void deleteBroker(@PathVariable Long id) {
        brokerService.deleteBroker(id);
    }

    @GetMapping("/{id}/flats")
    List<Flat> getFlats(@PathVariable Long id, @RequestParam Optional<Boolean> isBrokerApproved,
                        @RequestParam Optional<Boolean> isAgreementClosed) {
        return brokerService.getFlats(id, isBrokerApproved, isAgreementClosed);
    }

}
