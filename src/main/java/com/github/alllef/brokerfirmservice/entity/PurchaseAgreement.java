package com.github.alllef.brokerfirmservice.entity;

import com.github.alllef.brokerfirmservice.enums.DocType;
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
public class PurchaseAgreement {
    @Id
    private Long purchaseAgreementId;
    private boolean isCentralFirmApproved;
    private Long flatId;
    private LocalDate localDate;

}
