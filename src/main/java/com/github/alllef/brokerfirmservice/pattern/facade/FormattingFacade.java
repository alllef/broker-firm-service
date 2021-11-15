package com.github.alllef.brokerfirmservice.pattern.facade;

import com.github.alllef.brokerfirmservice.entity.FlatDocument;
import com.github.alllef.brokerfirmservice.pattern.facade.document_formatting.DocFormatter;
import com.github.alllef.brokerfirmservice.pattern.facade.document_formatting.PurchaseDocFormatter;
import com.github.alllef.brokerfirmservice.pattern.facade.document_formatting.RegistrationDocFormatter;
import com.github.alllef.brokerfirmservice.pattern.facade.document_formatting.SoldDocFormatter;

public class FormattingFacade {

    public String getFormattedDoc(FlatDocument doc) {
        DocFormatter formatter = null;

        switch (doc.getDocType()) {
            case SOLD -> formatter = new SoldDocFormatter();
            case PURCHASE -> formatter = new PurchaseDocFormatter();
            case REGISTRATION -> formatter = new RegistrationDocFormatter();
        }

        return formatter.formatDoc(doc);
    }
}
