package com.example.demo.health;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * new health state with name smartdb
 */
@Component("smartdb")
public class CustomHealthIndicator implements HealthIndicator {

    private volatile boolean state = true;

    private final String key = "Service X";

    @Override
    public Health health() {
        boolean trueState = (state = !state);
        if(trueState){
            return Health.up().withDetail(key, "it is fine").build();
        }
        return Health.down().withDetail(key, "something wrong").build();
    }
}
