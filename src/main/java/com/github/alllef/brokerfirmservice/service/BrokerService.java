package com.github.alllef.brokerfirmservice.service;

import com.github.alllef.brokerfirmservice.dto.DocumentDto;
import com.github.alllef.brokerfirmservice.dto.FlatRequest;
import com.github.alllef.brokerfirmservice.dto.FlatRequestDto;
import com.github.alllef.brokerfirmservice.entity.AgreementDocument;
import com.github.alllef.brokerfirmservice.entity.Flat;
import com.github.alllef.brokerfirmservice.entity.PurchaseAgreement;
import com.github.alllef.brokerfirmservice.entity.person.Broker;
import com.github.alllef.brokerfirmservice.entity.person.Client;
import com.github.alllef.brokerfirmservice.enums.DocType;
import com.github.alllef.brokerfirmservice.pattern.facade.FormattingFacade;
import com.github.alllef.brokerfirmservice.pattern.specification.range.FloorNumberRange;
import com.github.alllef.brokerfirmservice.pattern.specification.range.PriceRange;
import com.github.alllef.brokerfirmservice.pattern.specification.range.RoomNumberRange;
import com.github.alllef.brokerfirmservice.pattern.specification.range.TotalAreaRange;
import com.github.alllef.brokerfirmservice.repository.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    private final FormattingFacade formattingFacade;

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

    public List<Broker> findAll() {
        return brokerRepo.findAll();
    }

    public List<Flat> findAllFlats() {
        return flatRepo.findAll();
    }

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
        else if (isBrokerApproved.isPresent() && isAgreementClosed.isEmpty())
            return flatRepo.findByBrokerIdAndIsBrokerAccepted(brokerId, isBrokerApproved.get());
        else if (isBrokerApproved.isPresent() && isBrokerApproved.get() && isAgreementClosed.isPresent())
            return flatRepo.getFlatsByBrokerIdAnCentralFirmApproved(brokerId, isAgreementClosed.get());

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
                .dateOfIssue(LocalDate.now())
                .build();

        PurchaseAgreement savedAgreement = purchaseAgreementRepo.save(agreement);
        this.createDocumentAgreementsByFlatList(savedAgreement);
    }

    @Transactional
    public void createDocumentAgreementsByFlatList(PurchaseAgreement agreement) {
        for (DocType doc : DocType.values()) {
            AgreementDocument agreementDocument = AgreementDocument.builder()
                    .purchaseAgreementId(agreement.getPurchaseAgreementId())
                    .docType(doc)
                    .build();

            agreementDocumentRepo.save(agreementDocument);
        }
    }

    public List<DocumentDto> getDocumentsByFlat(Long flatId) {
        List<AgreementDocument> documents = agreementDocumentRepo.getDocumentsByFlatId(flatId);
        return documents.stream()
                .map(document -> DocumentDto.builder()
                        .agreementDocument(document)
                        .formattedDocument(formattingFacade.getFormattedDoc(document.getDocType()))
                        .build())
                .collect(Collectors.toList());
    }

    @Transactional
    public void approveDocument(AgreementDocument agreementDocument) {
        agreementDocument.toBuilder()
                .brokerApproved(true)
                .build();

        agreementDocumentRepo.save(agreementDocument);
    }

    @Transactional
    public void updatePurchaseAgreement(PurchaseAgreement purchaseAgreement) {
        purchaseAgreementRepo.save(purchaseAgreement);
    }

    @Transactional
    public void updateDocument(AgreementDocument agreementDocument) {
        agreementDocumentRepo.save(agreementDocument);
    }

    @Transactional
    public void deletePurchaseAgreement(Long purchaseAgreementId) {
        purchaseAgreementRepo.deleteById(purchaseAgreementId);
    }

    public List<PurchaseAgreement> getPurchaseAgreements(Optional<Boolean> allDocumentsAccepted,
                                                         Optional<Boolean> isCentralFirmApproved) {
        if (allDocumentsAccepted.isEmpty() && isCentralFirmApproved.isEmpty())
            return purchaseAgreementRepo.findAll();
        else if (allDocumentsAccepted.isPresent() && isCentralFirmApproved.isEmpty())
            return getPurchaseAgreementsWhereAllDocumentsAccepted();

        else if (allDocumentsAccepted.isPresent() && allDocumentsAccepted.get() && isCentralFirmApproved.isPresent())
            return purchaseAgreementRepo.findByCentralFirmApproved(isCentralFirmApproved.get());

        return new ArrayList<>();
    }

    private List<PurchaseAgreement> getPurchaseAgreementsWhereAllDocumentsAccepted() {
        List<AgreementDocument> documents = purchaseAgreementRepo.getAgreementDocuments(true);
        Set<Long> ids = new HashSet<>();

        for (AgreementDocument document : documents) {
            long purchaseAgreementId = document.getPurchaseAgreementId();
            ids.add(purchaseAgreementId);

            if (!document.isBrokerApproved())
                ids.remove(purchaseAgreementId);
        }

        return purchaseAgreementRepo.findAllById(ids);
    }
}