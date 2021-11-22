package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.entity.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlatRepo extends JpaRepository<Flat, Long> {

    List<Flat> findByBrokerId(long brokerId);

    List<Flat> findByBrokerIdNull();

    List<Flat> findByBrokerIdAndIsBrokerAccepted(long brokerId, boolean isBrokerAccepted);

    @Query(value = "select * from flat f  join purchase_agreement pa using(flat_id) where broker_id = ? AND central_firm_approved = ?",
            nativeQuery = true)
    List<Flat> getFlatsByBrokerIdAnCentralFirmApproved(Long brokerId, boolean isCentralFirmApproved);
}