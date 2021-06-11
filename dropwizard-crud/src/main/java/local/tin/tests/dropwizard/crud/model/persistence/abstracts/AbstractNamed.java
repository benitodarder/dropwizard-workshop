package local.tin.tests.dropwizard.crud.model.persistence.abstracts;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import local.tin.tests.dropwizard.crud.model.persistence.interfaces.INamed;




/**
 *
 * @author benitodarder
 */
@MappedSuperclass
public abstract class AbstractNamed extends AbstractIdentifiable implements INamed {

    @Column(name = "name")
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + super.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractNamed other = (AbstractNamed) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!this.name.equalsIgnoreCase(other.name)) {
            return false;
        }        
        return super.equals(obj);
    }
    
    

}
