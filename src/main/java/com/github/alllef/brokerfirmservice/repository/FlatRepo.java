package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.entity.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlatRepo extends JpaRepository<Flat, Long> {

    List<Flat> findByBrokerId(long brokerId);

    List<Flat> findByBrokerIdNull();
}
