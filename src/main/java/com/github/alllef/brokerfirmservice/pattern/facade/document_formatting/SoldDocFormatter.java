package com.github.alllef.brokerfirmservice.pattern.facade.document_formatting;

import com.github.alllef.brokerfirmservice.entity.FlatDocument;
import com.github.alllef.brokerfirmservice.enums.DocType;

import java.time.LocalDate;

public class SoldDocFormatter implements DocFormatter{

    @Override
    public String formatDoc(DocType doc) {
        String result = String.format("""
                <h1>Purchase document</h1>
                <p>I approve that I want to sell this flat</p>
                <h3>%s</h3>
                """, LocalDate.now());
        return result;
    }
}
