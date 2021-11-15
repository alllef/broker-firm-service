package com.github.alllef.brokerfirmservice.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder(toBuilder = true)
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class FlatRequest {
    private Long flatId;
    private Long clientId;
    private int floorNumberLowerBound;
    private int floorNumberUpperBound;
    private int totalAreaLowerBound;
    private int totalAreaUpperBound;
    private int priceLowerBound;
    private int priceUpperBound;
    private int roomsNumberLowerBound;
    private int roomsNumberUpperBound;
}
