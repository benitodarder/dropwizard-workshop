package local.tin.tests.dropwizard.hello.world;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;

public class HelloWorldConfiguration extends Configuration {
    

    @NotEmpty
    private String string = "Stranger";


    @JsonProperty
    public String getString() {
        return string;
    }

    @JsonProperty
    public void setString(String name) {
        this.string = name;
    }
}
