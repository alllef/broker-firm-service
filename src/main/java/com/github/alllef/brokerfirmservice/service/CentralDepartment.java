package com.github.alllef.brokerfirmservice.service;

import com.github.alllef.brokerfirmservice.entity.PurchaseAgreement;
import com.github.alllef.brokerfirmservice.entity.person.Broker;
import com.github.alllef.brokerfirmservice.repository.BrokerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentralDepartment {
    private final BrokerRepository brokerRepository;


    public List<Broker> getPossibleBrokers() {

    }

    public void setBrokerForRequest(Broker broker) {

    }

    public void approvePurchaseAgreement(PurchaseAgreement purchaseAgreement) {

    }

}
