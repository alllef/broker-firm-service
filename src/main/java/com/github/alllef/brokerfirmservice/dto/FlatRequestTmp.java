package com.github.alllef.brokerfirmservice.dto;

import lombok.*;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
public class FlatRequestTmp {
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
    private String description;
}
