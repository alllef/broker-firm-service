package com.github.alllef.brokerfirmservice.entity;

import com.github.alllef.brokerfirmservice.enums.DocType;

import javax.persistence.Id;
import java.time.LocalDate;

public class PurchaseAgreement {
    @Id
    private Long purchaseAgreementId;
    private boolean isCentralFirmApproved;
    private Long flatId;
    private LocalDate localDate;

    public static class Builder {
        private Long purchaseAgreementId;
        private boolean isCentralFirmApproved;
        private Long flatId;
        private LocalDate localDate;

        public Builder(long purchaseAgreementId) {
            this.purchaseAgreementId = purchaseAgreementId;
        }

        public Builder isCentralFirmApproved(boolean isCentralFirmApproved) {
            this.isCentralFirmApproved = isCentralFirmApproved;
            return this;
        }

        public Builder setFlatId(long flatId) {
            this.flatId = flatId;
            return this;
        }

        public Builder setLocalDate(LocalDate localDate) {
            this.localDate = localDate;
            return this;
        }

        public PurchaseAgreement build() {
            return new PurchaseAgreement(this);
        }
    }

    private PurchaseAgreement(Builder builder) {
        this.flatId = builder.flatId;
        this.purchaseAgreementId = builder.purchaseAgreementId;
        this.isCentralFirmApproved = builder.isCentralFirmApproved;
        this.localDate = builder.localDate;
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
        return getLocalDate() != null ? getLocalDate().equals(that.getLocalDate()) : that.getLocalDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getPurchaseAgreementId() != null ? getPurchaseAgreementId().hashCode() : 0;
        result = 31 * result + (isCentralFirmApproved() ? 1 : 0);
        result = 31 * result + (getFlatId() != null ? getFlatId().hashCode() : 0);
        result = 31 * result + (getLocalDate() != null ? getLocalDate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PurchaseAgreement{" +
                "purchaseAgreementId=" + purchaseAgreementId +
                ", isCentralFirmApproved=" + isCentralFirmApproved +
                ", flatId=" + flatId +
                ", localDate=" + localDate +
                '}';
    }
}
