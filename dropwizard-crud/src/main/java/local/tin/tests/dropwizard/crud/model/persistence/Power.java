package local.tin.tests.dropwizard.crud.model.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import local.tin.tests.dropwizard.crud.model.persistence.abstracts.AbstractNamed;
import local.tin.tests.dropwizard.crud.model.persistence.serializers.SuperHeroListSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 *
 * @author benitodarder
 */
@Entity
@Table(name = "POWER")
@NamedQueries({
    @NamedQuery(name = "local.tin.tests.dropwizard.crud.model.persistence.Power.findAll",
            query = "select e from Power e")})
public class Power extends AbstractNamed {

    @ManyToMany(mappedBy = "powers")
    @JsonSerialize(using = SuperHeroListSerializer.class)
    private List<SuperHero> superHeroes;

    public List<SuperHero> getSuperHeroes() {
        if (superHeroes == null) {
            superHeroes = new ArrayList<>();
        }
        return superHeroes;
    }

    public void setSuperHeroes(List<SuperHero> superHeroes) {
        this.superHeroes = superHeroes;
    }

}
