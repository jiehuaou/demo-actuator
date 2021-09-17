## apply filter with pattern
```
@WebFilter("/api/*")
public class MyFilter implements Filter { }
```
Spring boot's annotation @ServletComponentScan enables scanning of Servlet components. That means Servlet 3.0 annotations: @WebServlet, @WebFilter and @WebListener can be used along with Spring components. 
```
@ServletComponentScan
@SpringBootApplication
public class DemoApplication { ... }
```

## enable liveness and readiness
application properties
```
management.endpoint.health.probes.enabled=true
management.health.livenessState.enabled=true
management.health.readinessState.enabled=true
```
to modify the state
```
@Component
public class StateManager {
    private final ApplicationEventPublisher eventPublisher;
    public StateManager(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }
    public void acceptTraffic(){
        AvailabilityChangeEvent.publish(eventPublisher, MyState.SERVICE_IDLE, 
            ReadinessState.ACCEPTING_TRAFFIC);
    }
    public void refuseTraffic(){
        AvailabilityChangeEvent.publish(eventPublisher, MyState.SERVICE_BUSY, 
            ReadinessState.REFUSING_TRAFFIC);
    }
    public void serviceUp(){
        AvailabilityChangeEvent.publish(eventPublisher, MyState.SERVICE_UP, 
            LivenessState.CORRECT);
    }
    public void serviceDown(){
        AvailabilityChangeEvent.publish(eventPublisher, MyState.SERVICE_DOWN, 
            LivenessState.BROKEN);
    }
}

```
check the state
```
curl -v http://localhost:8080/actuator/health/liveness
curl -v http://localhost:8080/actuator/health/readiness
```