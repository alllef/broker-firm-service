package com.github.alllef.brokerfirmservice.entity;

import com.github.alllef.brokerfirmservice.enums.DocType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
public class FlatDocument {
    @Id
    private Long documentId;
    @Enumerated(EnumType.STRING)
    private DocType docType;
    private String docName;
    private String docContent;
    private String urlStateRegister;
}
