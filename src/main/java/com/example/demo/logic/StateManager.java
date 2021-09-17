package com.example.demo.logic;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class StateManager {
    private final ApplicationEventPublisher eventPublisher;
    private final ApplicationContext ctx ;

    public StateManager(ApplicationEventPublisher eventPublisher, ApplicationContext ctx) {
        this.eventPublisher = eventPublisher;
        this.ctx = ctx;
    }

    public void acceptTraffic(){
        AvailabilityChangeEvent.publish(eventPublisher, MyState.SERVICE_IDLE, ReadinessState.ACCEPTING_TRAFFIC);
    }
    public void refuseTraffic(){
        AvailabilityChangeEvent.publish(eventPublisher, MyState.SERVICE_BUSY, ReadinessState.REFUSING_TRAFFIC);
    }

    public void serviceUp(){
        AvailabilityChangeEvent.publish(eventPublisher, MyState.SERVICE_UP, LivenessState.CORRECT);
    }
    public void serviceDown(){
        AvailabilityChangeEvent.publish(eventPublisher, MyState.SERVICE_DOWN, LivenessState.BROKEN);
    }

}
