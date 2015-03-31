package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Repository;

import org.springframework.web.client.RestTemplate;
import org.markdown4j.Markdown4jProcessor;

import com.typesafe.config.ConfigFactory;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import play.api.libs.json.Json;

public class Application extends Controller {

	private static String metastatsBaseURL = ConfigFactory.load().getString("metastats.api.base.url");

	public static Result index() {

		List<Repository> repositories = new ArrayList<Repository>();

		com.surevine.community.hub.metastats.Repository[] metastatsRepos = getMetastatsRepositories();
		for(com.surevine.community.hub.metastats.Repository metastatsRepo : metastatsRepos) {

			Repository repo = new Repository();
			repo.setId(metastatsRepo.getName().replaceAll("[^A-Za-z0-9]", ""));
			repo.setRepository(metastatsRepo.getName());
			repo.setCommits(metastatsRepo.getNumCommits());
			repo.setContributors(metastatsRepo.getNumContributors());
			repo.setLead(metastatsRepo.getLeadContributor());
			repo.setLanguages(metastatsRepo.getLanguages());

			String processedReadme = "";
			try {
				processedReadme = new Markdown4jProcessor().process(metastatsRepo.getReadme());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repo.setReadme(processedReadme);

			repositories.add(repo);

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

	public static com.surevine.community.hub.metastats.Repository[] getMetastatsRepositories() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(metastatsBaseURL + "/" + "api/projects/all",
				com.surevine.community.hub.metastats.Repository[].class);
	}

	public static com.surevine.community.hub.metastats.Repository getMetastatsRepository(
			String repoStr) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(repoStr,
				com.surevine.community.hub.metastats.Repository.class);
	}

}
