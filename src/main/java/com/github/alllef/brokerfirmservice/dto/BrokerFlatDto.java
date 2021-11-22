package com.github.alllef.brokerfirmservice.dto;

import lombok.*;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@EqualsAndHashCode
@ToString
public class BrokerFlatDto {
    private long brokerId;
    private int flatNum;
}
