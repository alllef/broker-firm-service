package com.github.alllef.brokerfirmservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agreementDocumentId;
    private Long purchaseAgreementId;
    private boolean isBrokerApproved;
    private String urlStateRegister;
}
