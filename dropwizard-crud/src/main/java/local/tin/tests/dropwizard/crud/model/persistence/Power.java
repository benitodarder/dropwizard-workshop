package local.tin.tests.dropwizard.crud.model.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import local.tin.tests.dropwizard.crud.model.persistence.abstracts.AbstractNamed;
import local.tin.tests.dropwizard.crud.model.persistence.serializers.SuperHeroListSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Objects;

/**
 *
 * @author benitodarder
 */
@Entity
@Table(name = "POWER")
@NamedQuery(name = "local.tin.tests.dropwizard.crud.model.persistence.Power.findAll", query = "select e from Power e")
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

    @Override
    public int hashCode() {
        var hash = 5;
        hash = 41 * hash + Objects.hashCode(this.superHeroes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    
    

}
