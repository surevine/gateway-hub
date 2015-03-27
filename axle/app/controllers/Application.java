package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Repository;

import org.springframework.web.client.RestTemplate;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import com.surevine.community.hub.stash.StashApiClient;
import com.typesafe.config.ConfigFactory;

public class Application extends Controller {

	private static String metastatsBaseURL = null;

	public static Result index() {

		String[] sharedRepoProjects = ConfigFactory.load()
				.getString("shared.repo.groups").split(",");
		metastatsBaseURL = ConfigFactory.load().getString("metastats.base.url");

		List<Repository> repositories = null;
		for (String sharedRepoProject : sharedRepoProjects) {
			repositories = StashApiClient
					.loadRepositoriesForProject(sharedRepoProject);

			// Tell metastats how to init each of the repositories
			for (Repository repo : repositories) {

				initialiseMetastatsRepository(repo.getCloneURL());

				com.surevine.community.hub.metastats.Repository metastatsRepo = getMetastatsRepository(metastatsBaseURL
						+ "/" + "api/projects/" + repo.getRepository());

				repo.setLead(metastatsRepo.getLeadContributor());

				repo.setCommits(metastatsRepo.getNumCommits());
				
				repo.setContributors(metastatsRepo.getNumContributors());

				// TODO sort last commit
				
				// TODO sort pull requests
				
			}

		}

		return ok(index.render("Your new application is ready.", repositories));
	}

	public static void initialiseMetastatsRepository(String repoStr) {
		String initURL = metastatsBaseURL + "/" + "api/init/add";
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> urlVars = new HashMap<String, String>();
		urlVars.put("url", repoStr);
		restTemplate.postForLocation(initURL, null, urlVars);
	}

	public static com.surevine.community.hub.metastats.Repository getMetastatsRepository(
			String repoStr) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(repoStr,
				com.surevine.community.hub.metastats.Repository.class);
	}

}
