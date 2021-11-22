package com.github.alllef.brokerfirmservice.dto;


import com.github.alllef.brokerfirmservice.entity.person.Client;
import lombok.*;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@EqualsAndHashCode
@ToString
public class FlatRequestDto {
    private FlatRequest flatRequest;
    private Client client;
}
