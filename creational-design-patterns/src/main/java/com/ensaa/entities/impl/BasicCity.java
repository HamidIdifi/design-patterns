package com.ensaa.entities.impl;

import com.ensaa.entities.City;

public class BasicCity implements City {
    int nbOfSoldiers;
    int nbOfCitizens;

    public BasicCity(int nbOfSoldiers, int nbOfCitizens) {
        this.nbOfSoldiers = nbOfSoldiers;
        this.nbOfCitizens = nbOfCitizens;
    }

    public int getNbOfSoldiers() {
        return nbOfSoldiers;
    }

    public int getNbOfCitizens() {
        return nbOfCitizens;
    }

    public String report() {
        return this.nbOfSoldiers + "-" + this.nbOfCitizens;
    }

    public int prepareAttack() {
        int movingArmy = (int) (this.nbOfSoldiers * 0.5);
        this.nbOfSoldiers = this.nbOfSoldiers - movingArmy;
        return movingArmy;

    }
}
