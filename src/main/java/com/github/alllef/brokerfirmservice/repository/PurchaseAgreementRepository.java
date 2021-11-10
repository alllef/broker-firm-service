package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.entity.PurchaseAgreement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseAgreementRepository extends JpaRepository<Long, PurchaseAgreement> {

    List<PurchaseAgreement> findByBroker(Long brokerId);

    List<PurchaseAgreement> findByIsCentralFirmApprovedFalse();
}
