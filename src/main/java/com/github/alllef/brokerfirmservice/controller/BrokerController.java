package com.github.alllef.brokerfirmservice.controller;

import com.github.alllef.brokerfirmservice.entity.PurchaseAgreement;
import com.github.alllef.brokerfirmservice.service.BrokerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/brokers")
public class BrokerController {
    private final BrokerService brokerService;

    @GetMapping("/{id}/purchaseAgreements")
    List<PurchaseAgreement> getPurchaseAgreement(@PathVariable Long id) {
        return brokerService.getAgreementsByBrokerId(id);
    }

    @GetMapping("/{id}/approvedFlats")
    List<PurchaseAgreement> getPurchaseAgreement(@PathVariable Long id) {
        return brokerService.getAgreementsByBrokerId(id);
    }
}
