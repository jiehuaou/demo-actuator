package com.example.demo.rest;

import com.example.demo.logic.StateManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/state")
@RestController
public class StateController {

    @Autowired
    StateManager stateManager;

    @PutMapping("/idle")
    public String acceptTraffic(){
        stateManager.acceptTraffic();
        return "task submit [accept traffic]";
    }

    @PutMapping("/busy")
    public String refuseTraffic(){
        stateManager.refuseTraffic();
        return "task submit [refuse traffic]";
    }

    @PutMapping("/up")
    public String serviceUp(){
        stateManager.serviceUp();
        return "task submit [service up]";
    }

    @PutMapping("/down")
    public String serviceDown(){
        stateManager.serviceDown();
        return "task submit [service down]";
    }

}
