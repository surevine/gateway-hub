package controllers;
import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.surevine.community.hub.metastats.Repository;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a).isEqualTo(2);
    }

    @Test
    public void thatCanGetContentOutOfGarethsLocalSystem() {
    	Repository repo = Application.getMetastatsRepository("http://localhost:8080/metastats-garethf/api/projects/named/gateway-hub");
    	assertEquals(8, repo.getNumCommits());
    } 

}
