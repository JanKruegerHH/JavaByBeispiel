package org.sample.java.spring.vertx.service;

import java.util.HashMap;
import java.util.Map;

public enum EventType {

    INCREMENT("[Counter] Increment"),
    DECREMENT("[Counter] Decrement"),
    RESET("[Counter] Reset");

    private static final Map<String, EventType> fromString = new HashMap<>();
    static {
        for (EventType eventType : values()) {
            fromString.put(eventType.getValue(), eventType);
        }
    }

    private String value;

    EventType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EventType fromString(String value){
        return fromString.get(value);
    }
}
