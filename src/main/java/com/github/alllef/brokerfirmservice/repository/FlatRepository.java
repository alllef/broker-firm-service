package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.entity.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlatRepository extends JpaRepository<Flat, Long> {
    @Query(value = """
            select * from flat f2
            join purchase_agreement pa using(flat_id)
            where broker_id = ?""",
            nativeQuery = true)
    List<Flat> getFlatsByBroker(long brokerId);


    List<Flat> findByBrokerNull();
}
