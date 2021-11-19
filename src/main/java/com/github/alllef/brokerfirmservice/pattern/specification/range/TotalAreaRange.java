package com.github.alllef.brokerfirmservice.pattern.specification.range;


import com.github.alllef.brokerfirmservice.dto.FlatRequest;

public class TotalAreaRange extends FlatIntRange{
    public TotalAreaRange(int actualRange) {
        super(actualRange);
    }

    @Override
    public boolean test(FlatRequest flatRequest) {
        return new RangeSelector<Integer>(flatRequest.getTotalAreaLowerBound(), flatRequest.getTotalAreaUpperBound()).test(actualRange);
    }
}
