package com.github.alllef.brokerfirmservice.entity;

import com.github.alllef.brokerfirmservice.enums.DocType;
import lombok.*;

import javax.persistence.*;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
public class FlatDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;
    @Enumerated(EnumType.STRING)
    private DocType docType;
    private String docName;
    private String docContent;
    private String urlStateRegister;
}
