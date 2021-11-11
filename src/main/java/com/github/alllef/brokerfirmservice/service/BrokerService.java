package com.github.alllef.brokerfirmservice.service;

import com.github.alllef.brokerfirmservice.entity.AgreementDocument;
import com.github.alllef.brokerfirmservice.entity.Flat;
import com.github.alllef.brokerfirmservice.entity.PurchaseAgreement;
import com.github.alllef.brokerfirmservice.entity.person.Broker;
import com.github.alllef.brokerfirmservice.entity.person.Client;
import com.github.alllef.brokerfirmservice.repository.AgreementDocumentRepo;
import com.github.alllef.brokerfirmservice.repository.ClientRepo;
import com.github.alllef.brokerfirmservice.repository.FlatRepo;
import com.github.alllef.brokerfirmservice.repository.PurchaseAgreementRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class BrokerService {
    private final FlatRepo flatRepo;
    private final ClientRepo clientRepo;
    private final AgreementDocumentRepo agreementDocumentRepo;
    private final PurchaseAgreementRepo purchaseAgreementRepo;

    public void registerFlat(Broker broker, Flat flat) {
        Flat registered = flat.toBuilder()
                .isBrokerAccepted(true)
                .build();

        flatRepo.save(registered);
    }

    public List<PurchaseAgreement> getAgreementsByBrokerId(Long brokerId) {
        return purchaseAgreementRepo.findByBrokerId(brokerId);
    }

    public void addClientAddresses(Client client) {
        clientRepo.save(client);
    }

    public void createPurchaseAgreement(Flat flat) {
        PurchaseAgreement agreement = PurchaseAgreement.builder()
                .flatId(flat.getFlatId())
                .localDate(LocalDate.now())
                .build();

        purchaseAgreementRepo.save(agreement);
    }

    public void approveDocument(AgreementDocument agreementDocument) {
        agreementDocument.toBuilder()
                .isBrokerApproved(true)
                .build();

        agreementDocumentRepo.save(agreementDocument);
    }

}
