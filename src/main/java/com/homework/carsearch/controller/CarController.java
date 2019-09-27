package com.homework.carsearch.controller;

import com.homework.carsearch.model.Car;
import com.homework.carsearch.model.Color;
import com.homework.carsearch.repository.CarRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//TODO: Move logic into a service layer from routing layer.
@Api
@RestController
public class CarController {

    @Autowired
    CarRepository carRepository;

    @GetMapping("/car")
    public List<Car> findCars(@RequestParam(value = "color") Optional<Color> color,
                              @RequestParam(value = "hasSunRoof") Optional<Boolean> hasSunRoof,
                              @RequestParam(value = "isFourWheelDrive") Optional<Boolean> isFourWheelDrive,
                              @RequestParam(value = "hasLowMiles") Optional<Boolean> hasLowMiles,
                              @RequestParam(value = "hasPowerWindows") Optional<Boolean> hasPowerWindows,
                              @RequestParam(value = "hasNavigation") Optional<Boolean> hasNavigation,
                              @RequestParam(value = "hasHeatedSeats") Optional<Boolean> hasHeatedSeats
    ) {

        return carRepository.findAllByFilters(color.orElse(null),
                hasSunRoof.orElse(null),
                isFourWheelDrive.orElse(null),
                hasLowMiles.orElse(null),
                hasPowerWindows.orElse(null),
                hasNavigation.orElse(null),
                hasHeatedSeats.orElse(null));
    }

    @PostMapping("/car" )
    public void addCars(@RequestBody List<Car> car){
        carRepository.saveAll(car);
    }
}
