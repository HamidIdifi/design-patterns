package com.ensaa.factories.impl;

import com.ensaa.entities.impl.BasicCity;
import com.ensaa.entities.impl.BasicCountry;
import com.ensaa.factories.AbstractFactory;
import com.ensaa.factories.CountryFactory;

import java.util.ArrayList;
import java.util.List;

public class CountryFactoryImpl implements CountryFactory {
    private String name;
    private List<BasicCity> cities = new ArrayList<>();

    public CountryFactoryImpl(String... strings) {
        BasicCity city;
        this.name = strings[0];
        for (int i = 1; i < strings.length; i += 2) {
            city = AbstractFactory.getCity(new CityFactoryImpl(strings[i], strings[i + 1]));
            this.cities.add(city);
        }
    }

    @Override
    public BasicCountry createCountry() {
        return new BasicCountry(name, cities);
    }

    /*@Override
    public Country createCountry(String... strings) {
        Country country = new Country();
        City city;
        country.setName( strings[0]);
        for (int i = 1; i < strings.length; i += 2) {
            city = cityFactory.createCity(strings[i], strings[i + 1]);
            this.cities.add(city);
        }
        return country;
    }*/

}
