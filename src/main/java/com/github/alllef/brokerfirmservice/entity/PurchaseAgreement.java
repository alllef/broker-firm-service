package com.github.alllef.brokerfirmservice.entity;

import com.github.alllef.brokerfirmservice.enums.DocType;

import javax.persistence.Id;
import java.time.LocalDate;

public class PurchaseAgreement {
    @Id
    private Long purchaseAgreementId;
    private boolean isCentralFirmApproved;
    private Long flatId;
    private Long brokerId;
    private LocalDate localDate;

    public static class Builder {
        private Long purchaseAgreementId;
        private boolean isCentralFirmApproved;
        private Long flatId;
        private Long brokerId;
        private LocalDate localDate;

        public Builder(long purchaseAgreementId) {
            this.purchaseAgreementId = purchaseAgreementId;
        }

        private Builder isCentralFirmApproved(boolean isCentralFirmApproved) {
            this.isCentralFirmApproved = isCentralFirmApproved;
            return this;
        }

        private FlatDocument.Builder setDocName(String docName) {
            this.docName = docName;
            return this;
        }

        private FlatDocument.Builder setDocContent(String docContent) {
            this.docContent = docContent;
            return this;
        }

        private FlatDocument.Builder setUrlStateRegister(String urlStateRegister) {
            this.urlStateRegister = urlStateRegister;
            return this;
        }

        public PurchaseAgreement build() {
            return new PurchaseAgreement(this);
        }
    }

    private PurchaseAgreement(Builder builder) {
        this.documentId = builder.documentId;
        this.docContent = builder.docContent;
        this.docName = builder.docName;
        this.docType = builder.docType;
        this.urlStateRegister = builder.urlStateRegister;
    }

    public Long getPurchaseAgreementId() {
        return purchaseAgreementId;
    }

    public boolean isCentralFirmApproved() {
        return isCentralFirmApproved;
    }

    public Long getFlatId() {
        return flatId;
    }

    public Long getBrokerId() {
        return brokerId;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseAgreement)) return false;

        PurchaseAgreement that = (PurchaseAgreement) o;

        if (isCentralFirmApproved() != that.isCentralFirmApproved()) return false;
        if (getPurchaseAgreementId() != null ? !getPurchaseAgreementId().equals(that.getPurchaseAgreementId()) : that.getPurchaseAgreementId() != null)
            return false;
        if (getFlatId() != null ? !getFlatId().equals(that.getFlatId()) : that.getFlatId() != null) return false;
        if (getBrokerId() != null ? !getBrokerId().equals(that.getBrokerId()) : that.getBrokerId() != null)
            return false;
        return getLocalDate() != null ? getLocalDate().equals(that.getLocalDate()) : that.getLocalDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getPurchaseAgreementId() != null ? getPurchaseAgreementId().hashCode() : 0;
        result = 31 * result + (isCentralFirmApproved() ? 1 : 0);
        result = 31 * result + (getFlatId() != null ? getFlatId().hashCode() : 0);
        result = 31 * result + (getBrokerId() != null ? getBrokerId().hashCode() : 0);
        result = 31 * result + (getLocalDate() != null ? getLocalDate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PurchaseAgreement{" +
                "purchaseAgreementId=" + purchaseAgreementId +
                ", isCentralFirmApproved=" + isCentralFirmApproved +
                ", flatId=" + flatId +
                ", brokerId=" + brokerId +
                ", localDate=" + localDate +
                '}';
    }
}
