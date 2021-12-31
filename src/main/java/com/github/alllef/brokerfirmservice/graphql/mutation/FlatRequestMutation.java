package com.github.alllef.brokerfirmservice.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.github.alllef.brokerfirmservice.entity.FlatRequest;
import com.github.alllef.brokerfirmservice.entity.FlatRequestInput;
import com.github.alllef.brokerfirmservice.service.FlatRequestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FlatRequestMutation implements GraphQLMutationResolver {
    private final FlatRequestService flatRequestService;

    public FlatRequest create(long clientId, int floorNumberLowerBound, int floorNumberUpperBound, int totalAreaLowerBound,
                              int totalAreaUpperBound, int priceLowerBound, int priceUpperBound, int roomsNumberLowerBound,
                              int roomsNumberUpperBound, String description) {
        FlatRequest request = FlatRequest.builder()
                .clientId(clientId)
                .roomsNumberLowerBound(floorNumberLowerBound)
                .floorNumberUpperBound(floorNumberUpperBound)
                .totalAreaLowerBound(totalAreaLowerBound)
                .totalAreaUpperBound(totalAreaUpperBound)
                .priceLowerBound(priceLowerBound)
                .priceUpperBound(priceUpperBound)
                .roomsNumberLowerBound(roomsNumberLowerBound)
                .roomsNumberUpperBound(roomsNumberUpperBound)
                .description(description)
                .build();

        return flatRequestService.createFlatRequest(request);
    }

    public FlatRequest update(long id, int floorNumberLowerBound, int floorNumberUpperBound, int totalAreaLowerBound,
                              int totalAreaUpperBound, int priceLowerBound, int priceUpperBound, int roomsNumberLowerBound,
                              int roomsNumberUpperBound, String description) {
        FlatRequest request = FlatRequest.builder()
                .flatRequestId(id)
                .roomsNumberLowerBound(floorNumberLowerBound)
                .floorNumberUpperBound(floorNumberUpperBound)
                .totalAreaLowerBound(totalAreaLowerBound)
                .totalAreaUpperBound(totalAreaUpperBound)
                .priceLowerBound(priceLowerBound)
                .priceUpperBound(priceUpperBound)
                .roomsNumberLowerBound(roomsNumberLowerBound)
                .roomsNumberUpperBound(roomsNumberUpperBound)
                .description(description)
                .build();

        return flatRequestService.updateFlatRequest(request);
    }

    public void delete(long id) {
        flatRequestService.deleteFlatRequest(id);
    }
}
