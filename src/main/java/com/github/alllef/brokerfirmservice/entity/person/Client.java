package com.github.alllef.brokerfirmservice.entity.person;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client extends Person {
    @Id
    private Long clientId;
    private String clientAddress;

    public static class Builder extends Person.Builder<Client> {
        private final Long clientId;
        private String clientAddress;

        public Builder(long clientId) {
            this.clientId = clientId;
        }

        private Builder setClientAddress(String clientAddress) {
            this.clientAddress = clientAddress;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

    private Client(Builder builder) {
        super(builder);
        this.clientAddress = builder.clientAddress;
        this.clientId = builder.clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        if (!super.equals(o)) return false;

        Client client = (Client) o;

        if (getClientId() != null ? !getClientId().equals(client.getClientId()) : client.getClientId() != null)
            return false;
        return getClientAddress() != null ? getClientAddress().equals(client.getClientAddress()) : client.getClientAddress() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getClientId() != null ? getClientId().hashCode() : 0);
        result = 31 * result + (getClientAddress() != null ? getClientAddress().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientAddress='" + clientAddress + '\'' +
                '}';
    }
}
