package com.ensaa.observer.listeners;

import com.ensaa.observer.publishers.Observable;
import com.ensaa.observer.enums.EventType;

public interface Listener {
    void update(Observable observable, EventType eventType);
}
