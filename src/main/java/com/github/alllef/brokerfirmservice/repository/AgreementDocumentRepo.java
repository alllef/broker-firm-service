package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.entity.AgreementDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgreementDocumentRepo extends JpaRepository<AgreementDocument, Long> {

    List<AgreementDocument> findByPurchaseAgreementId(Long purchaseAgreementId);

    @Modifying
    @Query(value = "insert into agreement_document(purchase_agreement_id,url_state_register)values(?,?)",
            nativeQuery = true)
    void createDocument(Long purchaseAgreementId,String urlStateRegister);

}
