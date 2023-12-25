package com.ensaa.strategyUsingLambdas;

import com.ensaa.strategyUsingLambdas.services.ContextService;

public class Client {
    public static void main(String[] args) {
        ContextService contextService = new ContextService();
        contextService.perfromOperation(() -> System.out.println("the first strategy executed"));
        contextService.perfromOperation((Integer a) -> System.out.println(a),1);
    }
}
