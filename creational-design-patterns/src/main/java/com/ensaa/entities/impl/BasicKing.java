package com.ensaa.entities.impl;

import com.ensaa.entities.King;

public class BasicKing implements King {
    private String name;

    public BasicKing(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
