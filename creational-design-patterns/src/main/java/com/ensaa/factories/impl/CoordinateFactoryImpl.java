package com.ensaa.factories.impl;

import com.ensaa.entities.impl.BasicCoordinates;
import com.ensaa.factories.CoordinateFactory;

public class CoordinateFactoryImpl implements CoordinateFactory {

    String firstCountryName;
    String secondCountryName;
    int distance;

    public CoordinateFactoryImpl(String coordinates) {
        String[] parts = coordinates.split(":");
        this.firstCountryName = parts[0];
        this.distance = Integer.parseInt(parts[1]);
        this.secondCountryName = parts[2];
    }

    @Override
    public BasicCoordinates createCoordinates() {
        return new BasicCoordinates(
                firstCountryName,
                secondCountryName,
                distance);
    }
}
