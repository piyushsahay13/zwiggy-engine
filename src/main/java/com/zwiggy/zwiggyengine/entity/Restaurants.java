package com.zwiggy.zwiggyengine.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "RESTAURANTS")
@Data
public class Restaurants {
    @Id
    @Column(name ="RESTAURANTID")
    private String restaurantId;

    @Column(name = "RESTAURANTNAME", nullable = false)
    private String restaurantName;

    @Column(name = "EMAILID", nullable = false)
    private String emailId;

    @Column(name = "ISPUREVEG", nullable = false)
    private char isPureVeg;

    @Column(name = "AVGRATING")
    private Double avgRating;

    @Column(name = "CITY")
    private String city;
}



