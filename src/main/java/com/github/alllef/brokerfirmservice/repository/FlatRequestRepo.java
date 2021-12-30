package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.dto.FlatRequestTmp;
import com.github.alllef.brokerfirmservice.entity.FlatRequest;
import com.github.alllef.brokerfirmservice.entity.FlatRequestCache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlatRequestRepo extends JpaRepository<FlatRequest,Long> {
    @Query(value = """
            select * from flat_request_cache frc where frc.floor_number_lower_bound <=:floor and frc .floor_number_upper_bound >=:floor
            and frc .price_lower_bound <=:price and frc .price_upper_bound >=:price
            and frc.total_area_lower_bound <=:total_area and frc.total_area_lower_bound >=:total_area
            and frc.rooms_number_lower_bound <=:rooms_number and rooms_number_upper_bound >=:rooms_number""",
            nativeQuery = true)
    List<FlatRequest> findFilteredByFlat(@Param("floor") int floor, @Param("price") int price, @Param("total_area") int totalArea, @Param("rooms_number") int roomsNumber);

}
