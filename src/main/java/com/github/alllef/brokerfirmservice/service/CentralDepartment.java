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

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CentralDepartment {
    private final BrokerRepo brokerRepo;
    private final PurchaseAgreementRepo purchaseAgreementRepo;
    private final FlatRepo flatRepo;

    private Broker getLeastBusyBroker() {
        List<BrokerFlatView> groupedBrokers = brokerRepo.getGroupedBrokers();
        Optional<BrokerFlatView> optionalBrokerFlatView = groupedBrokers.stream()
                .min(Comparator.comparingInt(BrokerFlatView::getFlatNum));

        Long id = optionalBrokerFlatView.orElseThrow()
                .getBrokerId();

        return brokerRepo.findById(id)
                .orElseThrow();
    }

    @Transactional
    public void setBrokerForRequest(Flat flatRequest) {
        Broker broker = this.getLeastBusyBroker();
        Flat flat = flatRequest.toBuilder()
                .brokerId(broker.getBrokerId())
                .build();

        flatRepo.save(flat);
    }

    public void approvePurchaseAgreement(PurchaseAgreement purchaseAgreement) {
        PurchaseAgreement approvedPurchaseAgreement = purchaseAgreement.toBuilder()
                .centralFirmApproved(true)
                .build();

        purchaseAgreementRepo.save(approvedPurchaseAgreement);
    }

}
