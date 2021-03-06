package com.github.alllef.brokerfirmservice.controller;

import com.github.alllef.brokerfirmservice.dto.DocumentDto;
import com.github.alllef.brokerfirmservice.entity.AgreementDocument;
import com.github.alllef.brokerfirmservice.entity.PurchaseAgreement;
import com.github.alllef.brokerfirmservice.service.BrokerService;
import com.github.alllef.brokerfirmservice.service.CentralDepartment;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/purchaseAgreements")
public class PurchaseAgreementController {
    private final BrokerService brokerService;
    private final CentralDepartment centralDepartment;

    @GetMapping("/{flatId}/documents")
    public List<DocumentDto> getFormattedFlatDocuments(@PathVariable Long flatId) {
        return brokerService.getDocumentsByFlat(flatId);
    }

    @PutMapping("/documents/{id}")
    public void updateDocument(@PathVariable Long id, @RequestBody AgreementDocument agreementDocument) {
        brokerService.updateDocument(agreementDocument);
    }

    @GetMapping
    public List<PurchaseAgreement> getPurchaseAgreements(@RequestParam Optional<Boolean> isBrokerApproved,
                                                         @RequestParam Optional<Boolean> isCentralFirmApproved) {
        return brokerService.getPurchaseAgreements(isBrokerApproved, isCentralFirmApproved);
    }

    @PostMapping("/flats/{flatId}")
    public void createPurchaseAgreement(@PathVariable Long flatId) {
        brokerService.createPurchaseAgreement(flatId);
    }

    @PutMapping("/{id}")
    public void updateDocument(@PathVariable Long id, @RequestBody PurchaseAgreement purchaseAgreement) {
        brokerService.updatePurchaseAgreement(purchaseAgreement);
    }

    @DeleteMapping("/{id}")
    public void deletePurchaseAgreement(@PathVariable Long id) {
        brokerService.deletePurchaseAgreement(id);
    }
}