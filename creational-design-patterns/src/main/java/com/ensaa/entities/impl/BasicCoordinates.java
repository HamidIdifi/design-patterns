package com.ensaa.entities.impl;

import com.ensaa.entities.Coordinates;

public class BasicCoordinates implements Coordinates {
    String firstCountryName;
    String secondCountryName;
    int distance;

    public BasicCoordinates(String firstCountryName, String secondCountryName, int distance) {
        this.firstCountryName = firstCountryName;
        this.secondCountryName = secondCountryName;
        this.distance = distance;
    }

    public String getFirstCountryName() {
        return firstCountryName;
    }

    public String getSecondCountryName() {
        return secondCountryName;
    }

    public int getDistance() {
        return distance;
    }
}
