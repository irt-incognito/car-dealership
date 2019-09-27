package com.homework.carsearch.builder;

import com.homework.carsearch.model.Car;
import com.homework.carsearch.model.Color;

import java.util.Random;
import java.util.UUID;

public class CarBuilder {
    private String id = UUID.randomUUID().toString();
    private String make = "honda";
    private Integer year = new Random().nextInt(4);
    private Color color = Color.Red;
    private Integer price = new Random().nextInt();
    private Boolean hasSunroof = true;
    private Boolean isFourWheelDrive = true;
    private Boolean hasLowMiles = true;
    private Boolean hasPowerWindows = true;
    private Boolean hasNavigation = true;
    private Boolean hasHeatedSeats = true;

    public CarBuilder withMake(String make){
        this.make = make;
        return this;
    }
    public CarBuilder withColor(Color color){
        this.color = color;
        return this;
    }
    public CarBuilder withHasSunroof(Boolean bool){
        this.hasSunroof = bool;
        return this;
    }
    public CarBuilder withIsFourWheelDrive(Boolean bool){
        this.isFourWheelDrive = bool;
        return this;
    }
    public CarBuilder withHasLowMiles(Boolean bool){
        this.hasLowMiles = bool;
        return this;
    }
    public CarBuilder withHasPowerWindows(Boolean bool){
        this.hasPowerWindows = bool;
        return this;
    }
    public CarBuilder withHasNavigation(Boolean bool){
        this.hasNavigation = bool;
        return this;
    }
    public CarBuilder withHasHeatedSeats(Boolean bool){
        this.hasHeatedSeats = bool;
        return this;
    }

    public Car build(){
        return new Car(id, make, year, color, price, hasSunroof,
                isFourWheelDrive, hasLowMiles, hasPowerWindows,
                hasNavigation, hasHeatedSeats);
    }
}
