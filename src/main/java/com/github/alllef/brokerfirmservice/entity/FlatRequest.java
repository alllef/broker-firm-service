package com.github.alllef.brokerfirmservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
public class FlatRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flatRequestId;
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

    public FlatRequestCache toFlatRequestCache() {
        return FlatRequestCache.builder()
                .floorNumberLowerBound(this.getFloorNumberLowerBound())
                .floorNumberUpperBound(this.getFloorNumberUpperBound())
                .priceLowerBound(this.getPriceLowerBound())
                .priceUpperBound(this.getPriceUpperBound())
                .roomsNumberLowerBound(this.getRoomsNumberLowerBound())
                .roomsNumberUpperBound(this.getRoomsNumberUpperBound())
                .totalAreaLowerBound(this.getTotalAreaLowerBound())
                .totalAreaUpperBound(this.getTotalAreaUpperBound())
                .description(this.getDescription())
                .build();
    }
}
