package com.homework.carsearch.repository;

import com.homework.carsearch.builder.CarBuilder;
import com.homework.carsearch.model.Car;
import com.homework.carsearch.model.Color;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

    private Car car;
    private Car car2;
    private Car car3;
    private Car car4;
    private Car car5;
    private Car car6;
    private Car car7;
    private Car car8;

    @Autowired
    CarRepository carRepository;

    @Before
    public void setup(){
        car =  new CarBuilder().build();
        car2 =  new CarBuilder().withColor(Color.Black).withHasLowMiles(false).build();
        car3 =  new CarBuilder().withColor(Color.Gray).withHasSunroof(false).withIsFourWheelDrive(false).build();
        car4 =  new CarBuilder().withColor(Color.Silver).withHasSunroof(false).build();
        car5 =  new CarBuilder().withColor(Color.White).withHasLowMiles(false).build();
        car6 =  new CarBuilder().withColor(Color.Gray).withMake("Honda").build();
        car7 =  new CarBuilder().withColor(Color.Red).withHasSunroof(false).withHasPowerWindows(false).build();
        car8 =  new CarBuilder().withColor(Color.Silver).withHasNavigation(false).withHasHeatedSeats(false).build();

        List<Car> cars = Arrays.asList(car, car2, car3, car4, car5, car6, car7, car8);
        carRepository.saveAll(cars);
    }

    @Test
    public void findCarWithNoFiltersReturnsAllCars(){
        List<Car> cars = carRepository.findAllByFilters(null, null, null, null,null,null, null);
        assertThat(cars, containsInAnyOrder(car,car2, car3, car4, car5, car6, car7, car8));
    }

    @Test
    public void findCarsReturnsRedCars(){
        List<Car> cars = carRepository.findAllByFilters(
                Color.Red,
                null,
                null,
                null,
                null,
                null,
                null);
        assertThat(cars, containsInAnyOrder(car, car7));
    }

    @Test
    public void findCarsReturnsCarsWithSunRoof(){
        List<Car> cars = carRepository.findAllByFilters(
                null,
                true,
                null,
                null,
                null,
                null,
                null);
        assertThat(cars, containsInAnyOrder(car, car2, car5, car6, car8));
    }

    @Test
    public void findCarsReturnsCarsWithFourWheelDrive(){
        List<Car> cars = carRepository.findAllByFilters(
                null,
                null,
                true,
                null,
                null,
                null,
                null);
        assertThat(cars, containsInAnyOrder(car, car2, car4, car5, car6, car7, car8));
    }

    @Test
    public void findCarsReturnsCarsWithLowMiles(){
        List<Car> cars = carRepository.findAllByFilters(
                null,
                null,
                null,
                true,
                null,
                null,
                null);
        assertThat(cars, containsInAnyOrder(car, car3, car4, car6, car7, car8));
    }

    @Test
    public void findCarsReturnsCarsWithPowerWindows(){
        List<Car> cars = carRepository.findAllByFilters(
                null,
                null,
                null,
                null,
                true,
                null,
                null);
        assertThat(cars, containsInAnyOrder(car, car2, car3, car4, car5, car6,  car8));
    }

    @Test
    public void findCarsReturnsCarsWithNavigation(){
        List<Car> cars = carRepository.findAllByFilters(
                null,
                null,
                null,
                null,
                null,
                true,
                null);
        assertThat(cars, containsInAnyOrder(car, car2, car3, car4, car5, car6, car7));
    }

    @Test
    public void findCarsReturnsCarsWithHeatedSeats(){
        List<Car> cars = carRepository.findAllByFilters(
                null,
                null,
                null,
                null,
                null,
                null,
                true);
        assertThat(cars, containsInAnyOrder(car, car2, car3, car4, car5, car6, car7));
    }

    @Test
    public void findCarsReturnsRedCarsWithSunRoofs(){
         List<Car> cars = carRepository.findAllByFilters(
                 Color.Red,
                 true,
                 null,
                 null,
                 null,
                 null,
                 null);
         assertThat(cars, containsInAnyOrder(car));
    }

}