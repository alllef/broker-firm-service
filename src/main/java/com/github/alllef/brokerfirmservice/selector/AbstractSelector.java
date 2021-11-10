package com.github.alllef.brokerfirmservice.selector;

import java.util.function.Predicate;

public abstract class AbstractSelector<T> implements Predicate<T> {
    @Override
    public boolean test(T t) {
        return false;
    }

    @Override
    public Predicate<T> and(Predicate<? super T> other) {
        return Predicate.super.and(other);
    }

    @Override
    public Predicate<T> negate() {
        return Predicate.super.negate();
    }

    @Override
    public Predicate<T> or(Predicate<? super T> other) {
        return Predicate.super.or(other);
    }

}
