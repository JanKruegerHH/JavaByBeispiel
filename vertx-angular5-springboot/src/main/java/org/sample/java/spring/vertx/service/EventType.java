package org.sample.java.spring.vertx.service;

public enum EventType {

    INCREMENT("[Counter] Increment"),
    DECREMENT("[Counter] Decrement"),
    RESET("[Counter] Reset");

    private String value;

    EventType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
