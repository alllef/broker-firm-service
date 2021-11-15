package com.github.alllef.brokerfirmservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
public class AgreementDocument {
    @Id
    private Long agreementDocumentId;
    private Long purchaseAgreementId;
    private boolean isBrokerApproved;
    private String urlStateRegister;
}
