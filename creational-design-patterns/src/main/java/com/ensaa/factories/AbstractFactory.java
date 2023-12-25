package com.ensaa.factories;

import com.ensaa.entities.impl.*;

public class AbstractFactory {
    public static BasicCity getCity(CityFactory factory) {
        return factory.createCity();
    }

    public static BasicCoordinates getCoordinates(CoordinateFactory coordinateFactory) {
        return coordinateFactory.createCoordinates();
    }

    public static BasicCountry getCountry(CountryFactory countryFactory) {
        return countryFactory.createCountry();
    }

    public static BasicKing getKing(KingFactory kingFactory) {
        return kingFactory.createKing();
    }

    public static BasicMap getMap(MapFactory mapFactory) {
        return mapFactory.createMap();
    }

    public static SoldiersInEdges getSoldier(SoldierFactory soldierFactory) {
        return soldierFactory.createSoldier();
    }
}
