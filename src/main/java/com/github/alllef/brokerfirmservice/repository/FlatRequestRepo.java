package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.dto.FlatRequestTmp;
import com.github.alllef.brokerfirmservice.entity.FlatRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatRequestRepo extends JpaRepository<FlatRequest,Long> {
}
