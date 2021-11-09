package com.github.alllef.brokerfirmservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.File;
import java.util.Objects;

@Entity
public class FlatPhoto {
    @Id
    private Long flatPhotoId;
    private Long flatId;
    private File photo;

    public static class Builder {
        private Long flatPhotoId;
        private Long flatId;
        private File photo;

        public Builder(long flatPhotoId) {
            this.flatPhotoId = flatPhotoId;
        }

        private Builder setFlatId(Long flatId) {
            this.flatId = flatId;
            return this;
        }

        private Builder setPhoto(File photo) {
            this.photo=photo;
            return this;
        }

        public FlatPhoto build() {
            return new FlatPhoto(this);
        }
    }

    private FlatPhoto(Builder builder){
        this.flatId = builder.flatId;
        this.flatPhotoId=builder.flatPhotoId;
        this.photo=builder.photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlatPhoto)) return false;

        FlatPhoto flatPhoto = (FlatPhoto) o;

        return Objects.equals(flatPhotoId, flatPhoto.flatPhotoId);
    }

    @Override
    public int hashCode() {
        return flatPhotoId != null ? flatPhotoId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FlatPhoto{" +
                "flatPhotoId=" + flatPhotoId +
                '}';
    }
}
