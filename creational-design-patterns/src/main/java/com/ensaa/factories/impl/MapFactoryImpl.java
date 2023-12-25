package com.ensaa.factories.impl;

import com.ensaa.entities.impl.BasicCoordinates;
import com.ensaa.entities.impl.BasicMap;
import com.ensaa.factories.AbstractFactory;
import com.ensaa.factories.MapFactory;

import java.util.ArrayList;
import java.util.List;

public class MapFactoryImpl implements MapFactory {
    private List<BasicCoordinates> basicCoordinatesList = new ArrayList<>();

    public MapFactoryImpl(String mapString) {
        String[] parts = mapString.split(",");
        for (String part : parts) {
            BasicCoordinates basicCoordinates = AbstractFactory.getCoordinates(new CoordinateFactoryImpl(part));
            basicCoordinatesList.add(basicCoordinates);
        }
    }

    @Override
    public BasicMap createMap() {
        return new BasicMap(basicCoordinatesList);
    }
}
