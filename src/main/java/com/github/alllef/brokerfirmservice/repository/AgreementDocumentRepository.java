package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.entity.AgreementDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgreementDocumentRepository extends JpaRepository<AgreementDocument,Long> {

    List<AgreementDocument> findByPurchaseAgreementId(Long purchaseAgreementId);
}
