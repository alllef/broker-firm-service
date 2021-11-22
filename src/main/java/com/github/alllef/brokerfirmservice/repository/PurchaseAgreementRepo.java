package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.entity.AgreementDocument;
import com.github.alllef.brokerfirmservice.entity.PurchaseAgreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseAgreementRepo extends JpaRepository<PurchaseAgreement, Long> {
    @Query(value = "select * from purchase_agreement pa join flat f using(flat_id) where f.broker_id =?",
            nativeQuery = true)
    List<PurchaseAgreement> findByBrokerId(Long brokerId);

    List<PurchaseAgreement> findByCentralFirmApproved(boolean isCentralFirmApproved);

    @Query(value = """
            select * from purchase_agreement pa join agreement_document ad using(purchase_agreement_id)
            where ad.is_broker_approved =?""",
            nativeQuery = true)
    List<AgreementDocument> getAgreementDocuments(Boolean isBrokerApproved);
}