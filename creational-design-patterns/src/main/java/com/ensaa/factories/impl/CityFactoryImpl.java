package com.ensaa.factories.impl;

import com.ensaa.entities.impl.BasicCity;
import com.ensaa.factories.CityFactory;

public class CityFactoryImpl implements CityFactory {
    private int nbrOfSoldiersInCity;
    private int nbOfCitizensInCity;

    public CityFactoryImpl(String nbrOfSoldiersInCity, String nbOfCitizensInCity) {
        this.nbrOfSoldiersInCity = Integer.parseInt(nbrOfSoldiersInCity);
        this.nbOfCitizensInCity = Integer.parseInt(nbOfCitizensInCity);
    }

    @Override
    public BasicCity createCity() {
        return new BasicCity(nbrOfSoldiersInCity,nbOfCitizensInCity);

    }
}
