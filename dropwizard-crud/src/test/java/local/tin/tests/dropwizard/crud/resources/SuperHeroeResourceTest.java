package local.tin.tests.dropwizard.crud.resources;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import local.tin.tests.dropwizard.crud.CRUDApplication;
import local.tin.tests.dropwizard.crud.CRUDConfiguration;
import local.tin.tests.dropwizard.crud.daos.SuperHeroeDAO;
import local.tin.tests.dropwizard.crud.model.persistence.SuperHero;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;

/**
 *
 * @author benitodarder
 */
@ExtendWith(DropwizardExtensionsSupport.class)
class SuperHeroeResourceTest {


    private static DropwizardAppExtension<CRUDConfiguration> EXT = new DropwizardAppExtension<>(
            CRUDApplication.class,
            ResourceHelpers.resourceFilePath("crud.hsqldb.yaml")
        );
    private SuperHero superHeroe;

    @BeforeEach
    void setup() {
        superHeroe = new SuperHero();
        superHeroe.setName("name");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void create_returns_200_when_successful() {

        Client client = EXT.client();

        Response response = client.target(
                 String.format("http://localhost:%d/superHeroes/create", EXT.getLocalPort()))
                .request()
                .post(Entity.json(superHeroe));

        assertEquals(200, response.getStatus());
    }
    
     @Test
    public void create_assigns_id() {

        Client client = EXT.client();

        Response response = client.target(
                 String.format("http://localhost:%d/superHeroes/create", EXT.getLocalPort()))
                .request()
                .post(Entity.json(superHeroe));

        assertNotNull(response.readEntity(SuperHero.class).getId());
    }
    
    @Test
    public void test_test() {
        
        System.out.println("Test executed!");
        
        assertTrue(true);
    }
}
