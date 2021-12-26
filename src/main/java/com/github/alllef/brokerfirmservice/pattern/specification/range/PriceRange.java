package com.github.alllef.brokerfirmservice.pattern.specification.range;

import com.github.alllef.brokerfirmservice.dto.FlatRequestTmp;
import com.github.alllef.brokerfirmservice.entity.FlatRequest;

public class PriceRange extends FlatIntRange {
        public PriceRange(int actualRange) {
            super(actualRange);
        }

        @Override
        public boolean test(FlatRequest flatRequest) {
            return new RangeSelector<Integer>(flatRequest.getPriceLowerBound(), flatRequest.getPriceUpperBound()).test(actualRange);
        }
    }