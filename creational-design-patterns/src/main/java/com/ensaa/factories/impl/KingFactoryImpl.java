package com.ensaa.factories.impl;

import com.ensaa.entities.impl.BasicKing;
import com.ensaa.factories.KingFactory;

public class KingFactoryImpl implements KingFactory {
    String kingName;

    public KingFactoryImpl(String kingName) {
        this.kingName = kingName;
    }

    @Override
    public BasicKing createKing() {
        return new BasicKing(kingName);
    }
}
