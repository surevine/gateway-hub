package com.surevine.community.hub.metastats;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RepositoryTest {

	private static final int NUM_COMMITS = 8;
	private String testJSON = "{"
			  + "\"name\": \"gateway-hub\","
			  + "\"links\": null,"
			  + "\"fetchUrl\": \"https://github.com/surevine/gateway-hub.git\","
			  + "\"ageInMillis\": 0,"
			  + "\"byteCount\": 2546988,"
			  + "\"numFiles\": 64,"
			  + "\"numContributors\": 4,"
			  + "\"primaryLanguage\": \"CSS\","
			  + "\"cocomoCost\": \"255549\","
			  + "\"uri\": null,"
			  + "\"children\": null,"
			  + "\"readme\": \"Community Portal Hub\","
			  + "\"linesOfCode\": 20399,"
			  + "\"numCommits\": " + NUM_COMMITS
			  + "}";
	
	private String testLeadCommitterJSON = "{"
			  + "\"name\": \"gateway-hub\","
			  + "\"topContributors\": ["
			  + "{" 
			  + "\"name\":\"Ben\", "
			  + "\"numCommits\":1"
			  + "}, "
			  + "{" 
			  + "\"name\":\"Bill\", "
			  + "\"numCommits\":2"
			  + "}"
			  + "]"
			  + "}";
	
    @Test
    public void thatSerialisedJSONFromMetastatsCreatesRepository() {
    	ObjectMapper mapper = new ObjectMapper();
    	
    	try {
			Repository repo = mapper.readValue(testJSON, Repository.class);
			
			assertEquals(NUM_COMMITS, repo.getNumCommits());
		} catch (IOException e) {
			fail();
		}
    }
    
    
    @Test
    public void thatLeadCommiterIsIdentifiedCorrectly() {
    	ObjectMapper mapper = new ObjectMapper();
    	
    	try {
			Repository repo = mapper.readValue(testLeadCommitterJSON, Repository.class);
			
			assertEquals("Bill", repo.getLeadContributor());
		} catch (IOException e) {
			fail();
		}
    	
    }
}
