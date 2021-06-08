package local.tin.tests.dropwizard.hello.world;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(configuration.getString());
        environment.jersey().register(resource);
        final HelloWorldHealthCheck healthCheck = new HelloWorldHealthCheck(configuration.getString());
        environment.healthChecks().register("string", healthCheck);
        environment.jersey().register(resource);
    }

}
