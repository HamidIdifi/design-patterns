package com.ensaa.observer;

import com.ensaa.observer.enums.EventType;
import com.ensaa.observer.listeners.Listener;
import com.ensaa.observer.listeners.impl.FirstApp;
import com.ensaa.observer.listeners.impl.SecondApp;
import com.ensaa.observer.publishers.Configuration;

public class Client {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        Listener firstApp = new FirstApp();
        Listener secondApp = new SecondApp();
        configuration.eventManager.subscribe(EventType.Configuration_Update,firstApp);
        configuration.eventManager.subscribe(EventType.Configuration_Update,secondApp);
        //configuration.eventManager.subscribe(EventType.Invalid_Configuration,firstApp);
        //configuration.eventManager.subscribe(EventType.Configuration_Rollback,secondApp);
        try {
            configuration.configurationRollback();
            configuration.invalidConfiguration();
            configuration.configurationUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
