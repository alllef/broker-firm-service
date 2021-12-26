package com.github.alllef.brokerfirmservice.pattern.specification.range;


import com.github.alllef.brokerfirmservice.dto.FlatRequestTmp;

public class TotalAreaRange extends FlatIntRange{
    public TotalAreaRange(int actualRange) {
        super(actualRange);
    }

    @Override
    public boolean test(FlatRequestTmp flatRequestTmp) {
        return new RangeSelector<Integer>(flatRequestTmp.getTotalAreaLowerBound(), flatRequestTmp.getTotalAreaUpperBound()).test(actualRange);
    }
}
