package local.tin.tests.dropwizard.crud.daos;

import io.dropwizard.hibernate.AbstractDAO;
import java.util.List;
import local.tin.tests.dropwizard.crud.model.persistence.SuperHero;
import org.hibernate.SessionFactory;

/**
 *
 * @author benitodarder
 */
public class SuperHeroeDAO extends AbstractDAO<SuperHero> {
    
    public SuperHeroeDAO(SessionFactory factory) {
        super(factory);
    }



    public SuperHero create(SuperHero person) {
        return persist(person);
    }
    
    public SuperHero retrieve(Integer id) {
        return get(id);
    }    
    
    public void update(SuperHero person) {
        currentSession().update(person);
    }    

    public void delete(SuperHero superHero) {
        currentSession().delete(superHero);
    }
    
    public List<SuperHero> findAll() {
        return list(namedTypedQuery("local.tin.tests.dropwizard.crud.model.persistence.SuperHero.findAll"));
    }
}

