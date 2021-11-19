package com.github.alllef.brokerfirmservice.pattern.specification;

import java.util.function.Predicate;

public abstract class AbstractSelector<T> implements Predicate<T> {

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
