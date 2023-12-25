package com.ensaa.entities.impl;


import com.ensaa.entities.Map;

import java.util.ArrayList;
import java.util.List;

public class BasicMap implements Map {
    private List<BasicCoordinates> basicCoordinatesList = new ArrayList<>();
    public void addCoordinates(BasicCoordinates basicCoordinates){
        this.basicCoordinatesList.add(basicCoordinates);
    }

    public BasicMap(List<BasicCoordinates> basicCoordinatesList) {
        this.basicCoordinatesList = basicCoordinatesList;
    }

    public List<BasicCoordinates> getCoordinatesList() {
        return basicCoordinatesList;
    }
    /*public String findNearestCountry(){
        //return this.coordinatesList.stream().min(Comparator.comparing(c->c.getDistance()));
    }*/
}
