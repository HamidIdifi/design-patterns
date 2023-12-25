package com.ensaa.entities.impl;

import com.ensaa.entities.Country;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BasicCountry implements Country {
    private String name;
    private List<BasicCity> cities;
    private Optional<SoldiersInEdges> soldiersInEdges;

    public BasicCountry(String name, List<BasicCity> cities) {
        this.name = name;
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public List<BasicCity> getCities() {
        return cities;
    }

    public void setSoldiersInEdges(SoldiersInEdges soldiersInEdges) {
        this.soldiersInEdges = Optional.ofNullable(soldiersInEdges);
    }

    public int currentPower() {
        return
                cities.stream().mapToInt(BasicCity::getNbOfSoldiers).sum();
    }

    public String report() {
        return this.soldiersInEdges.map(inEdges -> this.name.charAt(0) + ":<" + IntStream.range(0, this.cities.size())
                .mapToObj(i -> this.name.charAt(0) + "c" + (i + 1) + ":" + this.cities.get(i).report())
                .collect(Collectors.joining(",")) + ">" + "-" + inEdges.getNbrOfSoldiersOnEdges()).orElseGet(() -> this.name.charAt(0) + ":<" + IntStream.range(0, this.cities.size())
                .mapToObj(i -> this.name.charAt(0) + "c" + (i + 1) + ":" + this.cities.get(i).report())
                .collect(Collectors.joining(",")) + ">");

    }

    public int prepareAttack() {
        return this.cities.stream()
                .mapToInt(BasicCity::prepareAttack)
                .sum();
    }

    public void movingArmyToEdges(int nbrOfArmy) {
        if(this.soldiersInEdges.isPresent()) {
            int nbrOfSoldiersOnEdges = this.soldiersInEdges.get().getNbrOfSoldiersOnEdges();
            this.soldiersInEdges = Optional.of(new SoldiersInEdges(nbrOfSoldiersOnEdges + nbrOfArmy));
        }
    }

    public void startWar(int nbrOfArmy) {
        if(this.soldiersInEdges.isPresent()) {
            int nbrOfSoldiersOnEdges = this.soldiersInEdges.get().getNbrOfSoldiersOnEdges();
            this.soldiersInEdges = Optional.of(new SoldiersInEdges(nbrOfSoldiersOnEdges - nbrOfArmy));
        }
    }

    public int gettingAttacked() {
        if(this.soldiersInEdges.isPresent()) {
            int nbrOfSoldiersOnEdges = this.soldiersInEdges.get().getNbrOfSoldiersOnEdges();
            this.soldiersInEdges = Optional.empty();
            return nbrOfSoldiersOnEdges;
        }
        return 0;
    }
}
