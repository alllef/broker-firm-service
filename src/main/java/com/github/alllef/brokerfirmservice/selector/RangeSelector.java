package com.github.alllef.brokerfirmservice.selector;

import java.util.Comparator;

public class RangeSelector<T extends Comparable<T>> extends AbstractSelector<T> {
    private final T leftBound;
    private final T rightBound;

    public RangeSelector(T leftBound, T rightBound) {
        this.leftBound = leftBound;
        this.rightBound = rightBound;
    }

    @Override
    public boolean test(T t) {
        return t.compareTo(leftBound) >= 0 && t.compareTo(rightBound) <= 0;
    }
}
