package com.github.alllef.brokerfirmservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class AgreementDocument {
    @Id
    private Long agreementDocumentId;
    private Long documentId;
    private Long purchaseAgreementId;
    private boolean isBrokerApproved;
}
