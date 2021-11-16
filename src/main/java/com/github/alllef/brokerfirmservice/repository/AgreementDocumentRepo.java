package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.entity.AgreementDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgreementDocumentRepo extends JpaRepository<AgreementDocument, Long> {

    List<AgreementDocument> findByPurchaseAgreementId(Long purchaseAgreementId);

}
