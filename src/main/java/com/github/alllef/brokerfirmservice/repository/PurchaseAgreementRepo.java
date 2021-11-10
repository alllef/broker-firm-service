package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.entity.PurchaseAgreement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseAgreementRepo extends JpaRepository<PurchaseAgreement,Long> {

    List<PurchaseAgreement> findByBroker(Long brokerId);

    List<PurchaseAgreement> findByIsCentralFirmApprovedFalse();
}
