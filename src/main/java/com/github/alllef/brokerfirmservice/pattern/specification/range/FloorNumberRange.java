package com.github.alllef.brokerfirmservice.pattern.specification.range;

import com.github.alllef.brokerfirmservice.dto.FlatRequestTmp;

public class FloorNumberRange extends FlatIntRange {
    public FloorNumberRange(int actualRange) {
        super(actualRange);
    }

    @Override
    public boolean test(FlatRequestTmp flatRequestTmp) {
        return new RangeSelector<>(flatRequestTmp.getFloorNumberLowerBound(), flatRequestTmp.getFloorNumberUpperBound()).test(actualRange);
    }
}
