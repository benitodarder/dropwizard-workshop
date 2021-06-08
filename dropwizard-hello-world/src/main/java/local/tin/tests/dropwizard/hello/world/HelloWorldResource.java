package local.tin.tests.dropwizard.hello.world;


import com.codahale.metrics.annotation.Timed;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String defaultName;

    public HelloWorldResource(String defaultName) {
        this.defaultName = defaultName;
    }

    @GET
    @Timed
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
}

