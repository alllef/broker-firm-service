package com.github.alllef.brokerfirmservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
public class Flat {
    @Id
    private Long flatId;
    private Long clientId;
    private Long brokerId;
    private boolean isBrokerAccepted;
    private int floorNumber;
    private int areaNumber;
    private int roomsNumber;
    private int price;
    private String description;

}
