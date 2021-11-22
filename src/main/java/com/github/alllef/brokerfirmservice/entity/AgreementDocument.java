package com.github.alllef.brokerfirmservice.entity;

import com.github.alllef.brokerfirmservice.enums.DocType;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
public class AgreementDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agreementDocumentId;
    private Long purchaseAgreementId;
    @Enumerated(EnumType.STRING)
    private DocType docType;
    private boolean brokerApproved;
}
