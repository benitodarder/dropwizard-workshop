package local.tin.tests.dropwizard.crud;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import local.tin.tests.dropwizard.crud.daos.PowerDAO;
import local.tin.tests.dropwizard.crud.daos.SuperHeroeDAO;
import local.tin.tests.dropwizard.crud.model.persistence.Power;
import local.tin.tests.dropwizard.crud.model.persistence.SuperHero;
import local.tin.tests.dropwizard.crud.resources.PowerResource;
import local.tin.tests.dropwizard.crud.resources.SuperHeroeResource;

/**
 *
 * @author benitodarder
 */
public class CRUDApplication extends Application<CRUDConfiguration> {

    public static void main(String[] args) throws Exception {
        new CRUDApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard-crud";
    }

    private final HibernateBundle<CRUDConfiguration> hibernateBundle = new HibernateBundle<CRUDConfiguration>(SuperHero.class, Power.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(CRUDConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };



    @Override
    public void initialize(Bootstrap<CRUDConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(CRUDConfiguration config, Environment environment) {
        var superHeroeDAO = new SuperHeroeDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new SuperHeroeResource(superHeroeDAO));
        var powerDAO = new PowerDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new PowerResource(powerDAO));        
    }

}
