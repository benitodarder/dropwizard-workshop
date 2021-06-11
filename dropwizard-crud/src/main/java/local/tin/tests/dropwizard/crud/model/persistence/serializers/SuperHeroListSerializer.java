package local.tin.tests.dropwizard.crud.model.persistence.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import java.util.List;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.ArrayList;
import local.tin.tests.dropwizard.crud.model.persistence.SuperHero;
/**
 *
 * @author benitodarder
 */
public class SuperHeroListSerializer extends JsonSerializer<List<SuperHero>> {

    @Override
    public void serialize(List<SuperHero> heroes, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        List<SuperHero> simpleSuperHeros = new ArrayList<>();

        heroes.forEach(current -> {
            SuperHero newItem = new SuperHero();
            newItem.setId(current.getId());
            newItem.setName(current.getName());
            simpleSuperHeros.add(newItem);
        });

       
        jsonGenerator.writeObject(simpleSuperHeros);
    }

}
