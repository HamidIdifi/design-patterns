package com.ensaa.lambdas;

import com.ensaa.entities.impl.BasicCity;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

//factory method design pattern
public class CityFactory {
    final static private Map<String, BiFunction<Integer, Integer, BasicCity>> map = new HashMap<>();

    static {
        map.put("basic_city", BasicCity::new);

    }

    public static BasicCity of(String name, int nbOfSoldiers, int nbOfCitizens) {
        BiFunction<Integer, Integer, BasicCity> p = map.get(name);
        if (p != null) {
            return p.apply(nbOfSoldiers, nbOfCitizens);
        }
        throw new RuntimeException("No such city " + name);
    }


}



