package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.entity.FlatRequestCache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlatRequestCacheRepo extends JpaRepository<FlatRequestCache, Long> {

    @Query(value = """
            select * from flat_request_cache frc where frc.floor_number_lower_bound <=30 and frc .floor_number_upper_bound >=30
            and frc .price_lower_bound <=70000 and frc .price_upper_bound >=70000
            and frc.total_area_lower_bound <=50 and frc.total_area_lower_bound >=50
            and frc.rooms_number_lower_bound <=4 and rooms_number_upper_bound >=4""",
            nativeQuery = true)
    List<FlatRequestCache> findFilteredByFlat(int floor, int price, int totalArea, int roomsNumber);
}
