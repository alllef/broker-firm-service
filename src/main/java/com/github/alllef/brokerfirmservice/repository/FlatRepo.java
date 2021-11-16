package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.entity.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlatRepo extends JpaRepository<Flat, Long> {

    List<Flat> findByBrokerId(long brokerId);

    List<Flat> findByBrokerIdNull();

    List<Flat> findByBrokerIdAndIsBrokerAccepted(long brokerId,boolean isBrokerAccepted);

    @Query(value = "select * from flat f  join purchase_agreement pa using(flat_id) where is_central_firm_approved = ? AND broker_id = ?",
            nativeQuery = true)
    List<Flat> getFlatsByBrokerIdAnIsCentralFirmApproved(Long brokerId, boolean isCentralFirmApproved);

}
