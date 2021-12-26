package com.github.alllef.brokerfirmservice.pattern.specification.range;

import com.github.alllef.brokerfirmservice.dto.FlatRequestTmp;

    public class PriceRange extends FlatIntRange {
        public PriceRange(int actualRange) {
            super(actualRange);
        }

        @Override
        public boolean test(FlatRequestTmp flatRequestTmp) {
            return new RangeSelector<Integer>(flatRequestTmp.getPriceLowerBound(), flatRequestTmp.getPriceUpperBound()).test(actualRange);
        }
    }