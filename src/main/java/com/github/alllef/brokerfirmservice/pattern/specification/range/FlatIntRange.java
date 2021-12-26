package com.github.alllef.brokerfirmservice.pattern.specification.range;

import com.github.alllef.brokerfirmservice.dto.FlatRequestTmp;
import com.github.alllef.brokerfirmservice.pattern.specification.AbstractSelector;

public abstract class FlatIntRange extends AbstractSelector<FlatRequestTmp> {
    protected final int actualRange;

        public FlatIntRange(int actualRange) {
        this.actualRange = actualRange;
    }

}
