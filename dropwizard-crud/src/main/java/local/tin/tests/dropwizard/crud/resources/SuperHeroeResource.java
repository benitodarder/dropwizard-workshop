package local.tin.tests.dropwizard.crud.resources;

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.hibernate.UnitOfWork;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import local.tin.tests.dropwizard.crud.daos.SuperHeroeDAO;
import local.tin.tests.dropwizard.crud.model.persistence.SuperHero;

/**
 *
 * @author benitodarder
 */
@Path("/superHeroes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SuperHeroeResource {

    private final SuperHeroeDAO superHeroeDAO;

    public SuperHeroeResource(SuperHeroeDAO superHeroeDAO) {
        this.superHeroeDAO = superHeroeDAO;
    }

    @POST
    @Path("/create")
    @Timed
    @UnitOfWork
    public SuperHero create(SuperHero superHeroe) {
        return superHeroeDAO.create(superHeroe);
    }

    @GET
    @Path("/{id}")
    @Timed
    @UnitOfWork
    public SuperHero retrieve(@PathParam("id") Integer id) {
        return superHeroeDAO.retrieve(id);
    }  
    
    @POST
    @Path("/update")
    @Timed
    @UnitOfWork
    public SuperHero update(SuperHero superHeroe) {
        superHeroeDAO.update(superHeroe);
        return superHeroeDAO.retrieve((Integer) superHeroe.getId());
    }   
    
    @DELETE
    @Path("/delete")
    @Timed
    @UnitOfWork
    public void delete(SuperHero superHeroe) {
        superHeroeDAO.delete(superHeroe);
    }     
    
    @GET
    @Path("/findAll")
    @Timed
    @UnitOfWork
    public List<SuperHero> findAll() {
        return superHeroeDAO.findAll();
    }    
}
