package com.github.alllef.brokerfirmservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flat {
    @Id
    private Long flatId;
    private Long clientId;
    private Long brokerId;
    private int floorNumber;
    private int areaNumber;
    private int roomsNumber;
    private int price;
    private String description;

    public static class Builder {
        private final Long flatId;
        private Long clientId;
        private Long brokerId;
        private int floorNumber;
        private int areaNumber;
        private int roomsNumber;
        private int price;
        private String description;

        public Builder(long flatId) {
            this.flatId = flatId;
        }

        private Builder setClientId(Long clientId) {
            this.clientId = clientId;
            return this;
        }

        private Builder setFloorNumber(int floorNumber) {
            this.floorNumber = floorNumber;
            return this;
        }

        private Builder setAreaNumber(int areaNumber) {
            this.areaNumber = areaNumber;
            return this;
        }

        private Builder setRoomsNumber(int roomsNumber) {
            this.roomsNumber = roomsNumber;
            return this;
        }

        private Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        private Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        private Builder setBrokerId(Long brokerId) {
            this.brokerId = brokerId;
            return this;
        }

        public Flat build() {
            return new Flat(this);
        }
    }

    private Flat(Builder builder) {
        this.flatId = builder.flatId;
        this.clientId = builder.clientId;
        this.areaNumber = builder.areaNumber;
        this.floorNumber = builder.floorNumber;
        this.description = builder.description;
        this.roomsNumber = builder.roomsNumber;
        this.brokerId = builder.brokerId;
        this.price = builder.price;
    }

    public Long getFlatId() {
        return flatId;
    }

    public Long getClientId() {
        return clientId;
    }

    public Long getBrokerId() {
        return brokerId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getAreaNumber() {
        return areaNumber;
    }

    public int getRoomsNumber() {
        return roomsNumber;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flat)) return false;

        Flat flat = (Flat) o;

        if (getFloorNumber() != flat.getFloorNumber()) return false;
        if (getAreaNumber() != flat.getAreaNumber()) return false;
        if (getRoomsNumber() != flat.getRoomsNumber()) return false;
        if (getPrice() != flat.getPrice()) return false;
        if (getFlatId() != null ? !getFlatId().equals(flat.getFlatId()) : flat.getFlatId() != null) return false;
        if (getClientId() != null ? !getClientId().equals(flat.getClientId()) : flat.getClientId() != null)
            return false;
        if (getBrokerId() != null ? !getBrokerId().equals(flat.getBrokerId()) : flat.getBrokerId() != null)
            return false;
        return getDescription() != null ? getDescription().equals(flat.getDescription()) : flat.getDescription() == null;
    }

    @Override
    public int hashCode() {
        int result = getFlatId() != null ? getFlatId().hashCode() : 0;
        result = 31 * result + (getClientId() != null ? getClientId().hashCode() : 0);
        result = 31 * result + (getBrokerId() != null ? getBrokerId().hashCode() : 0);
        result = 31 * result + getFloorNumber();
        result = 31 * result + getAreaNumber();
        result = 31 * result + getRoomsNumber();
        result = 31 * result + getPrice();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "flatId=" + flatId +
                ", clientId=" + clientId +
                ", brokerId=" + brokerId +
                ", floorNumber=" + floorNumber +
                ", areaNumber=" + areaNumber +
                ", roomsNumber=" + roomsNumber +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
