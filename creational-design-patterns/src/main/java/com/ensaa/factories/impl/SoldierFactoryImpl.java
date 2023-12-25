package com.ensaa.factories.impl;

import com.ensaa.entities.impl.SoldiersInEdges;
import com.ensaa.factories.SoldierFactory;

public class SoldierFactoryImpl implements SoldierFactory {
    int nbrOfSoldiersOnEdges;

    public SoldierFactoryImpl(String nbrOfSoldiersOnEdges) {
        this.nbrOfSoldiersOnEdges = Integer.parseInt(nbrOfSoldiersOnEdges);
    }

    @Override
    public SoldiersInEdges createSoldier() {
        return new SoldiersInEdges(nbrOfSoldiersOnEdges);
    }
}
