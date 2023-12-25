package com.ensaa.entities.impl;

import com.ensaa.entities.Soldier;

public class SoldiersInEdges implements Soldier {
    private int nbrOfSoldiersOnEdges;

    public SoldiersInEdges(int nbrOfSoldiersOnEdges) {
        this.nbrOfSoldiersOnEdges = nbrOfSoldiersOnEdges;
    }

    public int getNbrOfSoldiersOnEdges() {
        return nbrOfSoldiersOnEdges;
    }

    public void setNbrOfSoldiersOnEdges(int nbrOfSoldiersOnEdges) {
        this.nbrOfSoldiersOnEdges = nbrOfSoldiersOnEdges;
    }
}
