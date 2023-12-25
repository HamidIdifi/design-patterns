package com.ensaa.strategyUsingLambdas.services;

import java.util.function.Consumer;

public class ContextService {

    public ContextService() {
    }

    public void perfromOperation(Runnable runnable) {
        //begin
        System.out.println("the logic begin");
        System.out.println("choosing a strategy ...");
        //ooh! user decide wich algorithm will execute at this part
        runnable.run();
        System.out.println("the logic ends");
        //end
    }
    public void perfromOperation(Consumer<Integer> consumer,int a) {
        //begin
        System.out.println("the logic begin");
        System.out.println("choosing a strategy ...");
        //ooh! user decide wich algorithm will execute at this part
        consumer.accept(a);
        System.out.println("the logic ends");
        //end
    }
}
