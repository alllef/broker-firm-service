package com.github.alllef.brokerfirmservice.entity.person;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Broker extends Person {
    @Id
    private Long brokerId;

    public static class Builder extends Person.Builder<Broker> {
        private Long brokerId;

        Builder(long brokerId) {
            this.brokerId = brokerId;
        }

        @Override
        public Broker build() {
            return null;
        }
    }

    private Broker(Builder builder) {
        super(builder);
        this.brokerId = builder.brokerId;
    }

    public Long getBrokerId() {
        return brokerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Broker)) return false;
        if (!super.equals(o)) return false;

        Broker broker = (Broker) o;

        return getBrokerId() != null ? getBrokerId().equals(broker.getBrokerId()) : broker.getBrokerId() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getBrokerId() != null ? getBrokerId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Broker{" +
                "brokerId=" + brokerId +
                '}';
    }
}
