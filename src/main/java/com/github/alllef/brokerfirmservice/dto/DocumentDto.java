package com.github.alllef.brokerfirmservice.dto;

import com.github.alllef.brokerfirmservice.entity.AgreementDocument;
import lombok.*;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
public class DocumentDto {
    private AgreementDocument agreementDocument;
    private String formattedDocument;
}
