package com.github.alllef.brokerfirmservice.controller;

import com.github.alllef.brokerfirmservice.service.BrokerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/purchaseAgreements")
public class PurchaseAgreementController {
private final BrokerService brokerService;

   /* @GetMapping("/{id}/documents")
    public List<AgreementDocument> getAgreementDocuments(Long id) {

    }*/

   /* @GetMapping
    public List<PurchaseAgreement> getPurchaseAgreements(@RequestParam(required = false) boolean allDocumentsAccepted,
                                                         @RequestParam(required = false) boolean isCentralFirmApproved) {

    }*/

    /*@PostMapping("/flats/{flatId}")
    public void createPurchaseAgreement(@PathVariable) {

    }*/

    @PutMapping("/{id}")
    public void updatePurchaseAgreement() {}

    @DeleteMapping("/{id}")
    public void deletePurchaseAgreement(){}

}