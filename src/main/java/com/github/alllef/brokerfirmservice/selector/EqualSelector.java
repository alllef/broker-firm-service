package com.github.alllef.brokerfirmservice.selector;

public class EqualSelector<T> extends AbstractSelector<T> {
    private final T tFirst;

    public EqualSelector(T tFirst) {
        this.tFirst = tFirst;
    }

    @Override
    public boolean test(T t) {
        return t.equals(tFirst);
    }
}
