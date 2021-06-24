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
import local.tin.tests.dropwizard.crud.daos.PowerDAO;
import local.tin.tests.dropwizard.crud.model.persistence.Power;
import org.junit.jupiter.api.AfterEach;
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
class PowerResourceTest {

    private static final PowerDAO MOCKED_POWER_DAO = mock(PowerDAO.class);
    private static final ResourceExtension EXT = ResourceExtension.builder()
            .addResource(new PowerResource(MOCKED_POWER_DAO))
            .build();
    private Power power;

    @BeforeEach
    void setup() {
        power = new Power();
        power.setName("name");
    }

    @AfterEach
    void tearDown() {
        reset(MOCKED_POWER_DAO);
    }

    @Test
    void create() {

        EXT.target("/powers/create").request().post(Entity.json(power));
        
        verify(MOCKED_POWER_DAO).create(power);
    }
    
    @Test
    void test_test() {
        
        System.out.println("Test executed!");
        
        assertTrue(true);
    }
}
