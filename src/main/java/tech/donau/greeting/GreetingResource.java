package tech.donau.greeting;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.eventbus.Message;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/greeting")
public class GreetingResource {

    @Inject
    io.vertx.mutiny.core.eventbus.EventBus eventBus;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello(@QueryParam("name") String name) {
        return eventBus.<String>request("greeting", name)
                .onItem().apply(Message::body);
    }
}