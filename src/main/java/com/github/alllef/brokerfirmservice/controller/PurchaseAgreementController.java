package com.github.alllef.brokerfirmservice.controller;

import com.github.alllef.brokerfirmservice.entity.AgreementDocument;
import com.github.alllef.brokerfirmservice.entity.PurchaseAgreement;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/purchaseAgreements")
public class PurchaseAgreementController {

    @GetMapping("/{id}/documents")
    public List<AgreementDocument> getAgreementDocuments(Long id) {

    }

    @GetMapping
    public List<PurchaseAgreement> getPurchaseAgreements(@RequestParam(required = false) boolean allDocumentsAccepted,
                                                         @RequestParam(required = false) boolean isCentralFirmApproved) {

    }

    @PostMapping
    public void createPurchaseAgreement() {}

    @PutMapping("/{id}")
    public void updatePurchaseAgreement() {}

    @DeleteMapping("/{id}")
    public void deletePurchaseAgreement(){}

}