package com.github.alllef.brokerfirmservice.generator;

import com.github.alllef.brokerfirmservice.dto.FlatRequestTmp;
import com.github.alllef.brokerfirmservice.entity.FlatRequest;
import com.github.alllef.brokerfirmservice.entity.person.Client;
import com.github.alllef.brokerfirmservice.repository.ClientRepo;
import com.github.alllef.brokerfirmservice.repository.FlatRequestRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
@AllArgsConstructor
public class FlatRequestGenerator {
    private final FlatRequestRepo flatRequestRepo;
    private final ClientRepo clientRepo;

    public List<FlatRequest> generateFlatRequests(int number, List<Client> clients) {
        List<FlatRequest> requests = new ArrayList<>();

        for (int i = 0; i < number; i++)
            requests.add(generateFlatRequest(clients));
        return requests;
    }

    private FlatRequest generateFlatRequest(List<Client> clients) {
        var minMaxFloorNumber = upperLowerBound(1, 100);
        var minMaxTotalArea = upperLowerBound(10, 200);
        var minMaxPrice = upperLowerBound(5000, 200000);
        var minMaxRooms = upperLowerBound(1, 5);
        String description = getAlphaNumericString(100);

        long clientId = getRandomClient(clients);
        return FlatRequest.builder()
                .clientId(clientId)
                .floorNumberLowerBound(minMaxFloorNumber.getKey())
                .floorNumberUpperBound(minMaxFloorNumber.getValue())
                .priceLowerBound(minMaxPrice.getKey())
                .priceUpperBound(minMaxPrice.getValue())
                .roomsNumberLowerBound(minMaxRooms.getKey())
                .roomsNumberUpperBound(minMaxRooms.getValue())
                .totalAreaLowerBound(minMaxTotalArea.getKey())
                .totalAreaUpperBound(minMaxTotalArea.getValue())
                .description(description)
                .build();
    }

    private Map.Entry<Integer, Integer> upperLowerBound(int lowBound, int upperBound) {
        Random random = new Random();
        int min = random.nextInt(lowBound, upperBound);
        int max = Integer.MIN_VALUE;
        while (max < min)
            max = random.nextInt(lowBound, upperBound);

        return Map.entry(min, max);
    }

    private String getAlphaNumericString(int size) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(size);

        for (int i = 0; i < size; i++) {

            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }

    private long getRandomClient(List<Client> clients) {
        Random rand = new Random();
        int randClientIndex = rand.nextInt(clients.size());
        return clients.get(randClientIndex).getClientId();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void generateFlatRequests() {
        List<Client> clients = clientRepo.findAll();
        flatRequestRepo.saveAll(generateFlatRequests(100000, clients));
    }
}
