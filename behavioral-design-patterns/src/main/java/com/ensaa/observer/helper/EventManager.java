package com.ensaa.observer.helper;

import com.ensaa.observer.enums.EventType;
import com.ensaa.observer.listeners.Listener;
import com.ensaa.observer.publishers.Observable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    Map<EventType, List<Listener>> observers = new HashMap<>();
    public EventManager(EventType... operations){
        for (EventType operation:operations){
            this.observers.put(operation,new ArrayList<>());
        }
    }
    public void subscribe(EventType eventType,Listener listener){
        List<Listener> users=this.observers.get(eventType);
        users.add(listener);
    }
    public void unsubscribe(EventType eventType,Listener listener){
        List<Listener> users=this.observers.get(eventType);
        users.remove(listener);
    }
    public void notifyListeners(Observable observable,EventType eventType){
        List<Listener> users=this.observers.get(eventType);
        for (Listener listener:users){
            listener.update(observable, eventType);
        }
    }
}
