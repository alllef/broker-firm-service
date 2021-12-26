package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.entity.FlatRequestCache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatRequestCacheRepo extends JpaRepository<FlatRequestCache, Long> {
}
