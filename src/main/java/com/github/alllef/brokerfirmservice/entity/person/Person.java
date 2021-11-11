package com.github.alllef.brokerfirmservice.entity.person;

import lombok.*;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@EqualsAndHashCode
@ToString
public abstract class Person {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
