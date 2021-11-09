package com.github.alllef.brokerfirmservice.entity;

import com.github.alllef.brokerfirmservice.enums.DocType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class FlatDocument {
    @Id
    private Long documentId;
    @Enumerated(EnumType.STRING)
    private DocType docType;
    private String docName;
    private String docContent;
    private String urlStateRegister;

    public static class Builder {
        private final Long documentId;
        private DocType docType;
        private String docName;
        private String docContent;
        private String urlStateRegister;

        public Builder(long documentId) {
            this.documentId = documentId;
        }

        private Builder setDocType(DocType docType) {
            this.docType=docType;
            return this;
        }

        private Builder setDocName(String docName) {
            this.docName = docName;
            return this;
        }

        private Builder setDocContent(String docContent) {
            this.docContent =docContent;
            return this;
        }

        private Builder setUrlStateRegister(String urlStateRegister) {
            this.urlStateRegister = urlStateRegister;
            return this;
        }

        public FlatDocument build() {
            return new FlatDocument(this);
        }
    }

    private FlatDocument(Builder builder) {
        this.documentId = builder.documentId;
        this.docContent = builder.docContent;
        this.docName = builder.docName;
        this.docType = builder.docType;
        this.urlStateRegister = builder.urlStateRegister;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public DocType getDocType() {
        return docType;
    }

    public String getDocName() {
        return docName;
    }

    public String getDocContent() {
        return docContent;
    }

    public String getUrlStateRegister() {
        return urlStateRegister;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlatDocument)) return false;

        FlatDocument document = (FlatDocument) o;

        if (getDocumentId() != null ? !getDocumentId().equals(document.getDocumentId()) : document.getDocumentId() != null)
            return false;
        if (getDocType() != document.getDocType()) return false;
        if (getDocName() != null ? !getDocName().equals(document.getDocName()) : document.getDocName() != null)
            return false;
        if (getDocContent() != null ? !getDocContent().equals(document.getDocContent()) : document.getDocContent() != null)
            return false;
        return getUrlStateRegister() != null ? getUrlStateRegister().equals(document.getUrlStateRegister()) : document.getUrlStateRegister() == null;
    }

    @Override
    public int hashCode() {
        int result = getDocumentId() != null ? getDocumentId().hashCode() : 0;
        result = 31 * result + (getDocType() != null ? getDocType().hashCode() : 0);
        result = 31 * result + (getDocName() != null ? getDocName().hashCode() : 0);
        result = 31 * result + (getDocContent() != null ? getDocContent().hashCode() : 0);
        result = 31 * result + (getUrlStateRegister() != null ? getUrlStateRegister().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentId=" + documentId +
                ", docType=" + docType +
                ", docName='" + docName + '\'' +
                ", docContent='" + docContent + '\'' +
                ", urlStateRegister='" + urlStateRegister + '\'' +
                '}';
    }
}
