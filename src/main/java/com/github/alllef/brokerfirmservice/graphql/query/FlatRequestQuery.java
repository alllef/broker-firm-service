package com.github.alllef.brokerfirmservice.graphql.query;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.github.alllef.brokerfirmservice.entity.FlatRequest;
import com.github.alllef.brokerfirmservice.repository.FlatRequestRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FlatRequestQuery implements GraphQLQueryResolver {
    private final FlatRequestRepo flatRequestRepo;

    public FlatRequest getFlatRequest(long id) {
        return flatRequestRepo.findById(id)
                .orElseThrow();
    }
}
