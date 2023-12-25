package com.ensaa.strategy.strategies.impl;

import com.ensaa.strategy.strategies.Strategy;

public class StrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("strategy B is perfomed");
    }
}
