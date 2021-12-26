package com.github.alllef.brokerfirmservice.pattern.specification.range;

import com.github.alllef.brokerfirmservice.dto.FlatRequestTmp;
import com.github.alllef.brokerfirmservice.entity.FlatRequest;
import com.github.alllef.brokerfirmservice.pattern.specification.AbstractSelector;

public abstract class FlatIntRange extends AbstractSelector<FlatRequest> {
    protected final int actualRange;

        public FlatIntRange(int actualRange) {
        this.actualRange = actualRange;
    }

}
