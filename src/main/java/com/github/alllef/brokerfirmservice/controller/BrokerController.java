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

    @GetMapping("/{id}/purchaseAgreements")
    List<PurchaseAgreement> getPurchaseAgreements(@PathVariable Long id) {
        return brokerService.getAgreementsByBrokerId(id);
    }

    @GetMapping("/{id}")
    public Broker getBroker() {

    }

    @PostMapping
    public void createBroker() {
    }

    @PutMapping("/{id}")
    public void updateBroker() {

    }

    @DeleteMapping("/{id}")
    public void deleteBroker() {

    }

    @GetMapping("/{id}/flats")
    List<Flat> getFlats(@PathVariable Long id, @RequestParam(required = false) Optional<Boolean> isBrokerApproved,
                                @RequestParam(required = false) Optional<Boolean> isAgreementClosed) {
        return brokerService.getFlats(id);
    }

}
