package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.dto.BrokerFlatView;
import com.github.alllef.brokerfirmservice.entity.person.Broker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrokerRepository extends JpaRepository<Long, Broker> {
    @Query(value = """
            select broker_id, COUNT(flat_id) as flat_num from flat f2
                       join purchase_agreement pa  using(flat_id)
                        where is_central_firm_approved = false  group by broker_id""",
            nativeQuery = true)
    List<BrokerFlatView> getGroupedBrokers();
}
