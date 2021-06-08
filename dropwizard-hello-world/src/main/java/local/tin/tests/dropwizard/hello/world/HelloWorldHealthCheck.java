package local.tin.tests.dropwizard.hello.world;

import com.codahale.metrics.health.HealthCheck;

public class HelloWorldHealthCheck extends HealthCheck {
    private final String template;

    public HelloWorldHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        if (!template.matches("[a-zA-Z]")) {
            return Result.unhealthy("Unhealthy due to no letters included");
        }
        return Result.healthy();
    }
}