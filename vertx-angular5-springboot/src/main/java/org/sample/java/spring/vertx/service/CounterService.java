package org.sample.java.spring.vertx.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CounterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CounterService.class);
    private int total = 0;

    public void handleEvent(EventType eventType) {
        switch (eventType) {
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
        LOGGER.info("eventType: " + eventType.getValue());
        LOGGER.info("counter total: " + total);
//        return total;
    }

    public int getTotal(){
        return total;
    }
}
