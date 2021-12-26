package com.github.alllef.brokerfirmservice.entity;

import com.github.alllef.brokerfirmservice.dto.FlatRequestDto;
import com.github.alllef.brokerfirmservice.entity.person.Client;
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
public class FlatRequestCache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flatRequestCacheId;
    private int floorNumberLowerBound;
    private int floorNumberUpperBound;
    private int totalAreaLowerBound;
    private int totalAreaUpperBound;
    private int priceLowerBound;
    private int priceUpperBound;
    private int roomsNumberLowerBound;
    private int roomsNumberUpperBound;
    private String description;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public FlatRequest toFlatRequest() {
        return FlatRequest.builder()
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

    public static FlatRequestCache fromFlatRequestDto(FlatRequestDto flatRequestDto){
        Client cl = flatRequestDto.getClient();
        FlatRequest req = flatRequestDto.getFlatRequest();
        return FlatRequestCache.builder()
                .floorNumberLowerBound(req.getFloorNumberLowerBound())
                .floorNumberUpperBound(req.getFloorNumberUpperBound())
                .priceLowerBound(req.getPriceLowerBound())
                .priceUpperBound(req.getPriceUpperBound())
                .roomsNumberLowerBound(req.getRoomsNumberLowerBound())
                .roomsNumberUpperBound(req.getRoomsNumberUpperBound())
                .totalAreaLowerBound(req.getTotalAreaLowerBound())
                .totalAreaUpperBound(req.getTotalAreaUpperBound())
                .description(req.getDescription())
                .email(cl.getEmail())
                .firstName(cl.getFirstName())
                .lastName(cl.getLastName())
                .phoneNumber(cl.getPhoneNumber())
                .build();
    }
}
