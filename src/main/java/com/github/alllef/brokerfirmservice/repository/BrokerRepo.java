package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.entity.person.Broker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrokerRepo extends JpaRepository<Broker, Long> {
    @Query(value = "select broker_id, COUNT(flat_id) as flat_num from flat f2 group by broker_id",
            nativeQuery = true)
    List<Object[]> getGroupedBrokers();

}
