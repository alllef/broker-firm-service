package com.github.alllef.brokerfirmservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class AgreementDocument {
    @Id
    private Long agreementDocumentId;
    private Long documentId;
    private Long purchaseAgreementId;
    private boolean isBrokerApproved;

    public static class Builder {
        private Long agreementDocumentId;
        private Long documentId;
        private Long purchaseAgreementId;
        private boolean isBrokerApproved;

        public Builder(long agreementDocumentId) {
            this.agreementDocumentId = agreementDocumentId;
        }

        private Builder setDocumentId(long documentId) {
            this.documentId = documentId;
            return this;
        }

        private Builder setPurchaseAgreementId(long purchaseAgreementId) {
            this.purchaseAgreementId = purchaseAgreementId;
            return this;
        }

        private Builder isBrokerApproved(boolean isBrokerApproved) {
            this.isBrokerApproved = isBrokerApproved;
            return this;
        }

        public AgreementDocument build() {
            return new AgreementDocument(this);
        }
    }

    private AgreementDocument(Builder builder) {
        this.agreementDocumentId = builder.agreementDocumentId;
        this.documentId = builder.documentId;
        this.purchaseAgreementId = builder.purchaseAgreementId;
        this.isBrokerApproved=builder.isBrokerApproved;
    }

    public Long getAgreementDocumentId() {
        return agreementDocumentId;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public Long getPurchaseAgreementId() {
        return purchaseAgreementId;
    }

    public boolean isBrokerApproved() {
        return isBrokerApproved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AgreementDocument)) return false;

        AgreementDocument that = (AgreementDocument) o;

        if (isBrokerApproved() != that.isBrokerApproved()) return false;
        if (getAgreementDocumentId() != null ? !getAgreementDocumentId().equals(that.getAgreementDocumentId()) : that.getAgreementDocumentId() != null)
            return false;
        if (getDocumentId() != null ? !getDocumentId().equals(that.getDocumentId()) : that.getDocumentId() != null)
            return false;
        return getPurchaseAgreementId() != null ? getPurchaseAgreementId().equals(that.getPurchaseAgreementId()) : that.getPurchaseAgreementId() == null;
    }

    @Override
    public int hashCode() {
        int result = getAgreementDocumentId() != null ? getAgreementDocumentId().hashCode() : 0;
        result = 31 * result + (getDocumentId() != null ? getDocumentId().hashCode() : 0);
        result = 31 * result + (getPurchaseAgreementId() != null ? getPurchaseAgreementId().hashCode() : 0);
        result = 31 * result + (isBrokerApproved() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AgreementDocument{" +
                "agreementDocumentId=" + agreementDocumentId +
                ", documentId=" + documentId +
                ", purchaseAgreementId=" + purchaseAgreementId +
                ", isBrokerApproved=" + isBrokerApproved +
                '}';
    }
}
