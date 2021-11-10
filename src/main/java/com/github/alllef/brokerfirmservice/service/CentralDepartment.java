package com.github.alllef.brokerfirmservice.service;

import com.github.alllef.brokerfirmservice.entity.Flat;
import com.github.alllef.brokerfirmservice.entity.PurchaseAgreement;
import com.github.alllef.brokerfirmservice.entity.person.Broker;
import com.github.alllef.brokerfirmservice.repository.BrokerRepository;
import com.github.alllef.brokerfirmservice.selector.EqualSelector;
import com.github.alllef.brokerfirmservice.selector.RangeSelector;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
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
