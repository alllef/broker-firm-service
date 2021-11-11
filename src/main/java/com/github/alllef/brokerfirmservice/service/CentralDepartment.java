package com.github.alllef.brokerfirmservice.service;

import com.github.alllef.brokerfirmservice.dto.BrokerFlatView;
import com.github.alllef.brokerfirmservice.entity.Flat;
import com.github.alllef.brokerfirmservice.entity.PurchaseAgreement;
import com.github.alllef.brokerfirmservice.entity.person.Broker;
import com.github.alllef.brokerfirmservice.repository.BrokerRepo;
import com.github.alllef.brokerfirmservice.repository.FlatRepo;
import com.github.alllef.brokerfirmservice.repository.PurchaseAgreementRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CentralDepartment {
    private final BrokerRepo brokerRepo;
    private final PurchaseAgreementRepo purchaseAgreementRepo;
    private final FlatRepo flatRepo;

    private Broker getLeastBusyBroker() {
        Optional<BrokerFlatView> optionalBrokerFlatView = brokerRepo.getGroupedBrokers()
                .stream()
                .min(Comparator.comparingInt(BrokerFlatView::getFlatNum));

        Long id = optionalBrokerFlatView.orElseThrow().getBrokerId();

        return brokerRepo.findById(id).orElseThrow();
    }

    public void setBrokerForRequest(Flat flatRequest) {
        Broker broker = this.getLeastBusyBroker();
        Flat flat = flatRequest.toBuilder()
                .brokerId(broker.getBrokerId())
                .build();

        flatRepo.save(flat);
    }

    public void approvePurchaseAgreement(PurchaseAgreement purchaseAgreement) {
        PurchaseAgreement approvedPurchaseAgreement = purchaseAgreement.toBuilder()
                .isCentralFirmApproved(true)
                .build();

        purchaseAgreementRepo.save(approvedPurchaseAgreement);
    }

}
