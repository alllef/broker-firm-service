package com.github.alllef.brokerfirmservice.entity.person;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public static abstract class Builder<T extends Person> {
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;

        private Builder<T> setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        private Builder<T> setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        private Builder<T> setEmail(String email) {
            this.email = email;
            return this;
        }

        private Builder<T> setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public abstract T build();
    }

    protected Person(Builder builder) {
        this.phoneNumber=builder.phoneNumber;
        this.firstName = builder.firstName;
        this.email = builder.email;
        this.lastName = builder.lastName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getFirstName() != null ? !getFirstName().equals(person.getFirstName()) : person.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(person.getLastName()) : person.getLastName() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(person.getEmail()) : person.getEmail() != null) return false;
        return getPhoneNumber() != null ? getPhoneNumber().equals(person.getPhoneNumber()) : person.getPhoneNumber() == null;
    }

    @Override
    public int hashCode() {
        int result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
