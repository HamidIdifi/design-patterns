package com.ensaa.observer.publishers;

import com.ensaa.observer.enums.ConfigurationState;
import com.ensaa.observer.enums.EventType;
import com.ensaa.observer.helper.EventManager;

public class Configuration implements Observable<ConfigurationState> {
    public EventManager eventManager;
    public ConfigurationState state;

    public Configuration() {
        this.state = ConfigurationState.ACTIVE;
        this.eventManager = new EventManager(EventType.Configuration_Update, EventType.Configuration_Rollback, EventType.Invalid_Configuration);
    }

    public void configurationUpdate() {
        eventManager.notifyListeners(this, EventType.Configuration_Update);
    }

    public void configurationRollback() {
        setState(ConfigurationState.UNKNOWN);
        eventManager.notifyListeners(this, EventType.Configuration_Rollback);
    }

    public void invalidConfiguration() {
        setState(ConfigurationState.ERROR);
        eventManager.notifyListeners(this, EventType.Invalid_Configuration);
    }

    @Override
    public ConfigurationState getState() {
        return state;
    }

    public void setState(ConfigurationState state) {
        this.state = state;
        //eventManager.notifyListeners(this, EventType.Configuration_Update);
    }
}
