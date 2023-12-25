package com.ensaa.builders;

import com.ensaa.entities.impl.BasicCoordinates;
import com.ensaa.entities.impl.BasicMap;
import com.ensaa.factories.AbstractFactory;
import com.ensaa.factories.impl.MapFactoryImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class War {
    private final List<KingDom> kingDoms;
    private final BasicMap basicMap;

    public War(WarBuilder warBuilder) {
        this.kingDoms = warBuilder.kingDoms;
        this.basicMap = warBuilder.basicMap;
    }

    public void prepareAttack() {
        KingDom mostPowerfulKingDom = this.findMostPowerfulKingdom();
        String nearestCountry = findNearestCountry(mostPowerfulKingDom);
        String loinCountry = findLoinCountry(mostPowerfulKingDom);
        int nbr = mostPowerfulKingDom.prepareAttack(mostPowerfulKingDom.findCountryByName(loinCountry).get());
        mostPowerfulKingDom.movingArmyToEdges(mostPowerfulKingDom.findCountryByName(nearestCountry).get(), nbr);
    }

    private List<BasicCoordinates> findBorderCoordinates(KingDom kingDom) {
        return this.basicMap.getCoordinatesList().stream()
                .filter((coordinates) -> kingDom.isContainsCountry(coordinates.getFirstCountryName()) ^ kingDom.isContainsCountry(coordinates.getSecondCountryName()))
                .toList();
    }

    private String findNearestCountry(KingDom kingDom) {
        List<BasicCoordinates> coordinatesList = findBorderCoordinates(kingDom);
        BasicCoordinates minCoordinates = findCoordinatesWithMinDistance(coordinatesList);
        String nearestCountry;
        String firstCountryName = minCoordinates.getFirstCountryName();
        String secondCountryName = minCoordinates.getSecondCountryName();
        if (kingDom.isContainsCountry(firstCountryName)) {
            nearestCountry = firstCountryName;
        } else {
            nearestCountry = secondCountryName;
        }
        return nearestCountry;
    }

    private String findLoinCountry(KingDom kingDom) {
        List<BasicCoordinates> coordinatesList = findBorderCoordinates(kingDom);
        BasicCoordinates minCoordinates = findCoordinatesWithMaxDistance(coordinatesList);
        String loinCountry;
        String firstCountryName = minCoordinates.getFirstCountryName();
        String secondCountryName = minCoordinates.getSecondCountryName();
        if (kingDom.isContainsCountry(firstCountryName)) {
            loinCountry = firstCountryName;
        } else {
            loinCountry = secondCountryName;
        }
        return loinCountry;
    }

    private BasicCoordinates findCoordinatesWithMaxDistance(List<BasicCoordinates> coordinatesList) {
        return coordinatesList.stream()
                .max(Comparator.comparing(BasicCoordinates::getDistance))
                .get();
    }

    private BasicCoordinates findCoordinatesWithMinDistance(List<BasicCoordinates> coordinatesList) {
        return coordinatesList.stream()
                .min(Comparator.comparing(BasicCoordinates::getDistance))
                .get();
    }

    private KingDom findMostPowerfulKingdom() {
        return this.kingDoms.stream()
                .max(Comparator.comparing(KingDom::currentPower)).get();
    }

    private KingDom findLastPowerfulKingdom() {
        return this.kingDoms.stream()
                .min(Comparator.comparing(KingDom::currentPower)).get();
    }

    public void start() {
        KingDom mostPowerfulKingdom = findMostPowerfulKingdom();
        KingDom lastPowerfulKingdom = findLastPowerfulKingdom();
        int nbrOfArmy = lastPowerfulKingdom.gettingAttacked(lastPowerfulKingdom.findCountryByName(findNearestCountry(lastPowerfulKingdom)).get());
        mostPowerfulKingdom.startWar(mostPowerfulKingdom.findCountryByName(findNearestCountry(mostPowerfulKingdom)).get(), nbrOfArmy);

    }


    public static class WarBuilder {
        private List<KingDom> kingDoms = new ArrayList<>();
        private BasicMap basicMap;

        public WarBuilder addKingDom(KingDom kingdom) {
            kingDoms.add(kingdom);
            return this;
        }

        public WarBuilder addMap(String mapString) {
            this.basicMap = AbstractFactory.getMap(new MapFactoryImpl(mapString));
            return this;
        }

        public War build() {
            return new War(this);
        }
    }

}
