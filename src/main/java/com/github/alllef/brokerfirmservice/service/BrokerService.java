package com.github.alllef.brokerfirmservice.service;

import com.github.alllef.brokerfirmservice.entity.AgreementDocument;
import com.github.alllef.brokerfirmservice.entity.Flat;
import com.github.alllef.brokerfirmservice.entity.PurchaseAgreement;
import com.github.alllef.brokerfirmservice.entity.person.Broker;
import com.github.alllef.brokerfirmservice.entity.person.Client;
import com.github.alllef.brokerfirmservice.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BrokerService {
    private final FlatRepo flatRepo;
    private final ClientRepo clientRepo;
    private final AgreementDocumentRepo agreementDocumentRepo;
    private final PurchaseAgreementRepo purchaseAgreementRepo;
    private final BrokerRepo brokerRepo;

    public void registerFlat(Flat flat) {
        Flat registered = flat.toBuilder()
                .isBrokerAccepted(true)
                .build();

        flatRepo.save(registered);
    }

    public void createBroker(Broker broker) {
        brokerRepo.createBroker(broker.getFirstName(), broker.getLastName(), broker.getPhoneNumber(), broker.getEmail());
    }

    public void updateBroker(Broker broker) {
        brokerRepo.save(broker);
    }

    public Broker getBroker(Long brokerId) {
        return brokerRepo.findById(brokerId).orElseThrow();
    }

    public void deleteBroker(Long brokerId) {
        brokerRepo.deleteById(brokerId);
    }

    public List<Flat> getFlats(long brokerId, Optional<Boolean> isBrokerApproved, Optional<Boolean> isAgreementClosed) {
        if (isBrokerApproved.isEmpty() && isAgreementClosed.isEmpty())
            return flatRepo.findByBrokerId(brokerId);
        else if (isAgreementClosed.isPresent() && (isBrokerApproved.isEmpty() || isBrokerApproved.get()))
            return flatRepo.getFlatsByBrokerIdAnIsCentralFirmApproved(brokerId, isAgreementClosed.get());
        else if (isBrokerApproved.isPresent())
            return flatRepo.findByBrokerIdAndIsBrokerAccepted(brokerId, isBrokerApproved.get());
        else
            return new ArrayList<>();
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
