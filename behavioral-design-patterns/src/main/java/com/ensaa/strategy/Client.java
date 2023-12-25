package com.ensaa.strategy;

import com.ensaa.strategy.services.ContextService;
import com.ensaa.strategy.strategies.impl.StrategyA;
import com.ensaa.strategy.strategies.impl.StrategyB;

public class Client {
    public static void main(String[] args) {
        ContextService contextService = new ContextService();
        contextService.perfromOperation(new StrategyA());
        // switch to strategy B
        contextService.perfromOperation(new StrategyB());
    }
}
