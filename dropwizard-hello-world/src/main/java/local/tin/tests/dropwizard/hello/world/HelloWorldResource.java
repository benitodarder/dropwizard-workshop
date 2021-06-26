package local.tin.tests.dropwizard.hello.world;


import com.codahale.metrics.annotation.Timed;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

@Path("/hello-world")
public class HelloWorldResource {
    private final String defaultName;

    public HelloWorldResource(String defaultName) {
        this.defaultName = defaultName;
    }

    @GET
    @Path("/get")
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public HelloWorld sayHello(@QueryParam("name") Optional<String> name) {
        if (name.isPresent()) {
            return new HelloWorld(new Date(), getMessage(name.get()));
        } else {
            return new HelloWorld(new Date(), getMessage(defaultName));
        }
        
    }

    private String getMessage(String name) {
        return "Hello " + name + ", it's " + new Date();
    }
    
    @POST
    @Path("/post")
    @Timed
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public HelloWorld sayHelloByPost(String name) {
        if (!name.isBlank()) {
            return new HelloWorld(new Date(), getMessage(name));
        } else {
            return new HelloWorld(new Date(), getMessage(defaultName));
        }    }    
}

