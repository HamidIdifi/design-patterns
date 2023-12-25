package com.ensaa.observer.publishers;

import com.ensaa.observer.enums.ConfigurationState;

public interface Observable<T> {
    T getState();
}
