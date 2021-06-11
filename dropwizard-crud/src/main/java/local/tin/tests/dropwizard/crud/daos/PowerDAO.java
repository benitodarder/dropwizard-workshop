package local.tin.tests.dropwizard.crud.daos;

import io.dropwizard.hibernate.AbstractDAO;
import java.util.List;
import local.tin.tests.dropwizard.crud.model.persistence.Power;
import org.hibernate.SessionFactory;

/**
 *
 * @author benitodarder
 */
public class PowerDAO extends AbstractDAO<Power> {
    
    public PowerDAO(SessionFactory factory) {
        super(factory);
    }



    public Power create(Power person) {
        return persist(person);
    }
    
    public Power retrieve(Integer id) {
        return get(id);
    }    
    
    public void update(Power person) {
        currentSession().update(person);
    }    

    public void delete(Power superHero) {
        currentSession().delete(superHero);
    }
    
    public List<Power> findAll() {
        return list(namedTypedQuery("local.tin.tests.dropwizard.crud.model.persistence.Power.findAll"));
    }
}

