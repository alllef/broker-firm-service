package com.github.alllef.brokerfirmservice.service;

import com.github.alllef.brokerfirmservice.dto.FlatParamDto;
import com.github.alllef.brokerfirmservice.dto.FlatRequest;
import com.github.alllef.brokerfirmservice.entity.AgreementDocument;
import com.github.alllef.brokerfirmservice.entity.Flat;
import com.github.alllef.brokerfirmservice.entity.PurchaseAgreement;
import com.github.alllef.brokerfirmservice.entity.person.Broker;
import com.github.alllef.brokerfirmservice.entity.person.Client;
import com.github.alllef.brokerfirmservice.repository.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor
public class BrokerService {
    private final FlatRepo flatRepo;
    private final ClientRepo clientRepo;
    private final AgreementDocumentRepo agreementDocumentRepo;
    private final PurchaseAgreementRepo purchaseAgreementRepo;
    private final BrokerRepo brokerRepo;
    private final ModelMapper mapper;

    @Transactional
    public void registerFlat() {
        List<Flat> flatsWithoutBroker = flatRepo.findByBrokerIdNull();
        for (Flat flat : flatsWithoutBroker) {
            Flat registered = flat.toBuilder()
                    .isBrokerAccepted(true)
                    .build();

            flatRepo.save(registered);
        }
    }

    @Transactional
    public void createBroker(Broker broker) {
        brokerRepo.createBroker(broker.getFirstName(), broker.getLastName(), broker.getPhoneNumber(), broker.getEmail());
    }

    @Transactional
    public void updateBroker(Broker broker) {
        brokerRepo.save(broker);
    }

    public Broker getBroker(Long brokerId) {
        return brokerRepo.findById(brokerId).orElseThrow();
    }

    @Transactional
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

    public List<FlatRequest> getFlatRequests(long flatId) {
        Flat flat = flatRepo.findById(flatId).orElseThrow();

        FlatRequest[] response = WebClient.builder().baseUrl("http://localhost:8081")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build()
                .post()
                .uri("/flat-requests")
                .bodyValue(mapper.map(flat, FlatParamDto.class))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(FlatRequest[].class)
                .block();

        return Arrays.stream(response)
                .toList();
    }

    public List<PurchaseAgreement> getAgreementsByBrokerId(Long brokerId) {
        return purchaseAgreementRepo.findByBrokerId(brokerId);
    }

    @Transactional
    public void addClientAddresses(Client client) {
        clientRepo.save(client);
    }

    @Transactional
    public void createPurchaseAgreement(Flat flat) {
        PurchaseAgreement agreement = PurchaseAgreement.builder()
                .flatId(flat.getFlatId())
                .localDate(LocalDate.now())
                .build();

        purchaseAgreementRepo.save(agreement);
    }

    @Transactional
    public void approveDocument(AgreementDocument agreementDocument) {
        agreementDocument.toBuilder()
                .isBrokerApproved(true)
                .build();

        agreementDocumentRepo.save(agreementDocument);
    }

}
