package tech.donau.greeting;

import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    @ConsumeEvent(value = "greeting")
    public String onMessage(String name) {
        return "Hello, " + name;
    }

//    @ConsumeEvent(value = "greeting")
//    public Uni<String> onMessageAsynchronous(Message<String> name) {
//        return Uni.createFrom().item("Hello, " + name.body());
//    }
}
