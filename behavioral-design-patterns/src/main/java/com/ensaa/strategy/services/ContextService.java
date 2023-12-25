package com.ensaa.strategy.services;

import com.ensaa.strategy.strategies.Strategy;

public class ContextService {

    public ContextService() {
    }
    public void perfromOperation(Strategy strategy){
        //begin
        System.out.println("the logic begin");
        System.out.println("choosing a strategy ...");
        //ooh! user decide wich algorithm will execute at this part
        strategy.execute();
        System.out.println("the logic ends");
        //end
    }
}
