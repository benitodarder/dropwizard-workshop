package local.tin.tests.dropwizard.crud.model.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import local.tin.tests.dropwizard.crud.model.persistence.abstracts.AbstractNamed;
import local.tin.tests.dropwizard.crud.model.persistence.serializers.PowerListSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Objects;

/**
 *
 * @author benitodarder
 */
@Entity
@Table(name = "SUPERHERO")
@NamedQuery(name = "local.tin.tests.dropwizard.crud.model.persistence.SuperHero.findAll", query = "select e from SuperHero e")
public class SuperHero extends AbstractNamed {

    @ManyToMany
    @JoinTable(
            name = "SUPERHEROPOWERS",
            joinColumns = @JoinColumn(name = "superHeroId"),
            inverseJoinColumns = @JoinColumn(name = "powerId"))
    @JsonSerialize(using = PowerListSerializer.class)
    private List<Power> powers;

    public List<Power> getPowers() {
        if (powers == null) {
            powers = new ArrayList<>();
        }
        return powers;
    }

    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        var hash = 5;
        hash = 97 * hash + Objects.hashCode(this.powers);
        return hash;
    }
    
    
}
