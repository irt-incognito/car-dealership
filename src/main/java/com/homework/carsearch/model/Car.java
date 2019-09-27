package com.homework.carsearch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    private String id;
    @Column
    private String make;
    @Column
    private Integer year;
    @Column
    private Color color;
    @Column
    private Integer price;
    @Column
    private Boolean hasSunroof;
    @Column
    private Boolean isFourWheelDrive;
    @Column
    private Boolean hasLowMiles;
    @Column
    private Boolean hasPowerWindows;
    @Column
    private Boolean hasNavigation;
    @Column
    private Boolean hasHeatedSeats;
}
