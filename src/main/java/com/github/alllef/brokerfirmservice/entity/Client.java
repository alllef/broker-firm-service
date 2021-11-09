package com.github.alllef.brokerfirmservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {
    @Id
    private Long clientId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String clientAddress;

    public static class Builder {
        private final Long clientId;
        private final String firstName;
        private final String lastName;
        private final String email;

        private String phoneNumber;
        private String clientAddress;

        public Builder(long clientId, String firstName, String lastName, String email) {
            this.clientId = clientId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        private Builder setPhoneNumber(String phoneNumber){
            this.phoneNumber=phoneNumber;
            return this;
        }

        private Builder setClientAddress(String clientAddress){
            this.clientAddress = clientAddress;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

    private Client(Builder builder) {
        this.clientId = builder.clientId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.clientAddress = builder.clientAddress;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
    }

    public Long getClientId() {
        return clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (getClientId() != null ? !getClientId().equals(client.getClientId()) : client.getClientId() != null)
            return false;
        if (getFirstName() != null ? !getFirstName().equals(client.getFirstName()) : client.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(client.getLastName()) : client.getLastName() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(client.getEmail()) : client.getEmail() != null) return false;
        if (getPhoneNumber() != null ? !getPhoneNumber().equals(client.getPhoneNumber()) : client.getPhoneNumber() != null)
            return false;
        return getClientAddress() != null ? getClientAddress().equals(client.getClientAddress()) : client.getClientAddress() == null;
    }

    @Override
    public int hashCode() {
        int result = getClientId() != null ? getClientId().hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        result = 31 * result + (getClientAddress() != null ? getClientAddress().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                '}';
    }
}
