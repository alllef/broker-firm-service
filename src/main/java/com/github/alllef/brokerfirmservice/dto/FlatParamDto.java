package com.github.alllef.brokerfirmservice.dto;

import lombok.*;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
public class FlatParamDto {
    private int floorNumber;
    private int totalArea;
    private int roomsNumber;
    private int price;
}
