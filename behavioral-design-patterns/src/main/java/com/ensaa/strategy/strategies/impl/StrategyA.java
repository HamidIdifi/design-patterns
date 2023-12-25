package com.ensaa.strategy.strategies.impl;

import com.ensaa.strategy.strategies.Strategy;

public class StrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("strategy A performed!");
    }
}
