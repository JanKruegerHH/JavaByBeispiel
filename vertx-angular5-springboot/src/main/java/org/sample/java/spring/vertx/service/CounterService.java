package org.sample.java.spring.vertx.service;

import org.springframework.stereotype.Service;

@Service
public class CounterService {

    final static String INCREMENT = "[Counter] Increment";
    final static String DECREMENT = "[Counter] Decrement";
    final static String RESET = "[Counter] Reset";

    private int total = 0;

    public void handleEvent(EventType eventType) {
        switch(eventType.getValue()) {
            case INCREMENT:
                total++;
                break;
            case DECREMENT:
                total--;
                break;
            case RESET:
                total = 0;
                break;
        }
    }
}
