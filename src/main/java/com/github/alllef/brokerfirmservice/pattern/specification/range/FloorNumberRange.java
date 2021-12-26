package com.github.alllef.brokerfirmservice.pattern.specification.range;

import com.github.alllef.brokerfirmservice.dto.FlatRequestTmp;
import com.github.alllef.brokerfirmservice.entity.FlatRequest;

public class FloorNumberRange extends FlatIntRange {
    public FloorNumberRange(int actualRange) {
        super(actualRange);
    }

    @Override
    public boolean test(FlatRequest flatRequest) {
        return new RangeSelector<>(flatRequest.getFloorNumberLowerBound(), flatRequest.getFloorNumberUpperBound()).test(actualRange);
    }
}
