package com.ensaa.observer.listeners.impl;

import com.ensaa.observer.enums.EventType;
import com.ensaa.observer.listeners.Listener;
import com.ensaa.observer.publishers.Observable;

public class FirstApp implements Listener {
    @Override
    public void update(Observable observable, EventType eventType) {
        System.out.println("an operation of "+eventType+" was performing,and the current state is "+ observable.getState());
    }
}
