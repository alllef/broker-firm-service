package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.entity.person.Broker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrokerRepository extends JpaRepository<Long, Broker> {

    List<Broker> getUnoccupiedBrokers();
}
