package com.homework.carsearch.repository;

import com.homework.carsearch.model.Car;
import com.homework.carsearch.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, String>, JpaSpecificationExecutor {

@Query("SELECT c FROM Car c WHERE (:color is null or c.color = :color) and" +
        "(:hasSunRoof is null or c.hasSunroof = :hasSunRoof) and" +
        "(:isFourWheelDrive is null or c.isFourWheelDrive = :isFourWheelDrive) and" +
        "(:hasLowMiles is null or c.hasLowMiles = :hasLowMiles) and" +
        "(:hasPowerWindows is null or c.hasPowerWindows = :hasPowerWindows) and" +
        "(:hasNavigation is null or c.hasNavigation = :hasNavigation) and" +
        "(:hasHeatedSeats is null or c.hasHeatedSeats = :hasHeatedSeats)")
     List<Car> findAllByFilters(@Param("color") Color color,
                               @Param("hasSunRoof") Boolean hasSunRoof,
                               @Param("isFourWheelDrive") Boolean isFourWheelDrive,
                               @Param("hasLowMiles") Boolean hasLowMiles,
                               @Param("hasPowerWindows") Boolean hasPowerWindows,
                               @Param("hasNavigation") Boolean hasNavigation,
                               @Param("hasHeatedSeats") Boolean hasHeatedSeats
                               );
}
