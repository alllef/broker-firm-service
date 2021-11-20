package com.github.alllef.brokerfirmservice.pattern.facade;

import com.github.alllef.brokerfirmservice.enums.DocType;
import com.github.alllef.brokerfirmservice.pattern.facade.document_formatting.DocFormatter;
import com.github.alllef.brokerfirmservice.pattern.facade.document_formatting.PurchaseDocFormatter;
import com.github.alllef.brokerfirmservice.pattern.facade.document_formatting.RegistrationDocFormatter;
import com.github.alllef.brokerfirmservice.pattern.facade.document_formatting.SoldDocFormatter;
import org.springframework.stereotype.Component;

@Component
public class FormattingFacade {

    public String getFormattedDoc(DocType doc) {
        DocFormatter formatter = null;

        switch (doc) {
            case SOLD -> formatter = new SoldDocFormatter();
            case PURCHASE -> formatter = new PurchaseDocFormatter();
            case REGISTRATION -> formatter = new RegistrationDocFormatter();
        }

        return formatter.formatDoc(doc);
    }
}
