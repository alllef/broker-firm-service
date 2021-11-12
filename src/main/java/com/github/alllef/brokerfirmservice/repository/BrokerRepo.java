package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.dto.BrokerFlatView;
import com.github.alllef.brokerfirmservice.entity.person.Broker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrokerRepo extends JpaRepository<Broker, Long> {

    @Modifying
    @Query(value = " insert into broker(first_name,last_name,phone_number,email)values(?,?,?,?)",
            nativeQuery = true)
    void createBroker(String firstName,String lastName,String phoneNumber,String email);

    @Query(value = """
            select broker_id, COUNT(flat_id) as flat_num from flat f2
                       join purchase_agreement pa  using(flat_id)
                        where is_central_firm_approved = false  group by broker_id""",
            nativeQuery = true)
    List<BrokerFlatView> getGroupedBrokers();

}
