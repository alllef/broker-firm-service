package com.github.alllef.brokerfirmservice.service;

import com.github.alllef.brokerfirmservice.dto.FlatParamDto;
import com.github.alllef.brokerfirmservice.dto.FlatRequest;
import com.github.alllef.brokerfirmservice.dto.FlatRequestDto;
import com.github.alllef.brokerfirmservice.entity.AgreementDocument;
import com.github.alllef.brokerfirmservice.entity.Flat;
import com.github.alllef.brokerfirmservice.entity.FlatDocument;
import com.github.alllef.brokerfirmservice.entity.PurchaseAgreement;
import com.github.alllef.brokerfirmservice.entity.person.Broker;
import com.github.alllef.brokerfirmservice.entity.person.Client;
import com.github.alllef.brokerfirmservice.pattern.specification.range.FloorNumberRange;
import com.github.alllef.brokerfirmservice.pattern.specification.range.PriceRange;
import com.github.alllef.brokerfirmservice.pattern.specification.range.RoomNumberRange;
import com.github.alllef.brokerfirmservice.pattern.specification.range.TotalAreaRange;
import com.github.alllef.brokerfirmservice.repository.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrokerService {
    private final FlatRepo flatRepo;
    private final ClientRepo clientRepo;
    private final AgreementDocumentRepo agreementDocumentRepo;
    private final PurchaseAgreementRepo purchaseAgreementRepo;
    private final BrokerRepo brokerRepo;
    private final ModelMapper mapper;
    private final RequestPerformer requestPerformer;

    /*@Transactional
    public void registerFlat(Flat flat) {
        List<Flat> flatsWithoutBroker = flatRepo.findByBrokerIdNull();
        for (Flat flat : flatsWithoutBroker) {
            Flat registered = flat.toBuilder()
                    .isBrokerAccepted(true)
                    .build();

            flatRepo.save(registered);
        }
    }*/

    @Transactional

    public void createBroker(Broker broker) {
        brokerRepo.save(broker);
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

    public List<FlatRequestDto> getFlatRequests(long flatId) {
        Flat flat = flatRepo.findById(flatId).orElseThrow();
        List<FlatRequest> allFlatRequests = requestPerformer.getAllFlatRequests();

        List<FlatRequestDto> filteredAllRequests = allFlatRequests.stream()
                .filter(tmpFlat -> new FloorNumberRange(flat.getFloorNumber())
                        .and(new RoomNumberRange(flat.getRoomsNumber()))
                        .and(new PriceRange(flat.getPrice()))
                        .and(new TotalAreaRange(flat.getTotalArea())).test(tmpFlat))
                .map(tmpFlat -> new FlatRequestDto(tmpFlat, requestPerformer.getRequestClientById(tmpFlat.getClientId())))
                .collect(Collectors.toList());

        filteredAllRequests.addAll(requestPerformer.getFilteredFlatRequestsDto(flat));
        return filteredAllRequests;
    }

    public List<PurchaseAgreement> getAgreementsByBrokerId(Long brokerId) {
        return purchaseAgreementRepo.findByBrokerId(brokerId);
    }

    @Transactional
    public void addClientAddresses(Client client) {
        clientRepo.save(client);
    }


    @Transactional
    public void createPurchaseAgreement(Long flatId) {
        PurchaseAgreement agreement = PurchaseAgreement.builder()
                .flatId(flatId)
                .localDate(LocalDate.now())
                .build();

        PurchaseAgreement savedAgreement = purchaseAgreementRepo.save(agreement);
        List<FlatDocument> documents = this.getDocumentsByFlat(flatId);
        this.createDocumentAgreementsByFlatList(documents, savedAgreement);
    }

    @Transactional
    private void createDocumentAgreementsByFlatList(List<FlatDocument> docsList, PurchaseAgreement agreement) {
        for (FlatDocument doc : docsList) {
            AgreementDocument agreementDocument = AgreementDocument.builder()
                    .purchaseAgreementId(agreement.getPurchaseAgreementId())
                    .urlStateRegister(doc.getUrlStateRegister())
                    .build();

            agreementDocumentRepo.save(agreementDocument);
        }
    }

    @Transactional
    public void approveDocument(AgreementDocument agreementDocument) {
        agreementDocument.toBuilder()
                .isBrokerApproved(true)
                .build();

        agreementDocumentRepo.save(agreementDocument);
    }

    public List<PurchaseAgreement> getPurchaseAgreements(Optional<Boolean> allDocumentsAccepted,
                                                         Optional<Boolean> isCentralFirmApproved) {
        if (allDocumentsAccepted.isEmpty() && isCentralFirmApproved.isEmpty())
            return purchaseAgreementRepo.findAll();
        else if (allDocumentsAccepted.isPresent()) {
            if (isCentralFirmApproved.isPresent() && allDocumentsAccepted.get())
                return purchaseAgreementRepo.findByIsCentralFirmApproved(isCentralFirmApproved.get());
            else if (isCentralFirmApproved.isEmpty())
                return purchaseAgreementRepo.
        }
    }
}
