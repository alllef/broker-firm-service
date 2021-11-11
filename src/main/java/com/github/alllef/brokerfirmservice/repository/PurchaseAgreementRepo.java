package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.entity.PurchaseAgreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseAgreementRepo extends JpaRepository<PurchaseAgreement, Long> {
    @Query(value = "select * from purchase_agreement pa join flat f using(flat_id) where f.broker_id =?",
            nativeQuery = true)
    List<PurchaseAgreement> findByBrokerId(Long brokerId);

    List<PurchaseAgreement> findByIsCentralFirmApprovedFalse();
}
