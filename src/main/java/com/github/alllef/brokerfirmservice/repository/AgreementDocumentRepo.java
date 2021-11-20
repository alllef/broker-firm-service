package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.entity.AgreementDocument;
import com.github.alllef.brokerfirmservice.entity.FlatDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgreementDocumentRepo extends JpaRepository<AgreementDocument, Long> {

    List<AgreementDocument> findByPurchaseAgreementId(Long purchaseAgreementId);

    @Query(value = """
            select ad.agreement_document_id ,ad.doc_type,ad.purchase_agreement_id ,ad .is_broker_approved from agreement_document ad
            join purchase_agreement pa using(purchase_agreement_id) where flat_id = ?""",
            nativeQuery = true)
    List<AgreementDocument> getDocumentsByFlatId(Long flatId);
}
