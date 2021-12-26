package com.github.alllef.brokerfirmservice.pattern.specification.range;


import com.github.alllef.brokerfirmservice.dto.FlatRequestTmp;

public class RoomNumberRange extends FlatIntRange {
    public RoomNumberRange(int actualRange) {
        super(actualRange);
    }

    @Override
    public boolean test(FlatRequestTmp flatRequestTmp) {
        return new RangeSelector<>(flatRequestTmp.getPriceLowerBound(), flatRequestTmp.getPriceUpperBound()).test(actualRange);
    }

}
