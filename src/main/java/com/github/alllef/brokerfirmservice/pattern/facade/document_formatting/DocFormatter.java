package com.github.alllef.brokerfirmservice.pattern.facade.document_formatting;
import com.github.alllef.brokerfirmservice.entity.FlatDocument;
import com.github.alllef.brokerfirmservice.enums.DocType;

public interface DocFormatter {
     String formatDoc(DocType doc);
}
