package local.tin.tests.dropwizard.crud.model.persistence.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import java.util.List;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.ArrayList;
import local.tin.tests.dropwizard.crud.model.persistence.Power;

/**
 *
 * @author benitodarder
 */
public class PowerListSerializer extends JsonSerializer<List<Power>> {

    @Override
    public void serialize(List<Power> powers, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        List<Power> simplePowers = new ArrayList<>();

        powers.forEach(current -> {
            Power newItem = new Power();
            newItem.setId(current.getId());
            newItem.setName(current.getName());
            simplePowers.add(newItem);
        });

        jsonGenerator.writeObject(simplePowers);
    }

}
