package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import models.*;

import java.util.ArrayList;
import java.util.List;

import com.surevine.community.hub.stash.StashApiClient;
import com.typesafe.config.ConfigFactory;

public class Application extends Controller {

    public static Result index() {

    	String[] sharedRepoProjects = ConfigFactory.load().getString("shared.repo.groups").split(",");

    	for(String sharedRepoProject : sharedRepoProjects) {
    		List<Repository> repositories = StashApiClient.loadRepositoriesForProject(sharedRepoProject);

    		// TODO load more info for each repo
    	}



        List<Repository> l = new ArrayList<Repository>();
        {
          Repository p = new Repository();
          p.id = "my-great-project";
          p.repository = "~smith/my-great-project";
          p.lead = "Steve Smith";
          p.commits = 3;
          p.pull_requests = 4;
          p.contributors = 5;
          p.state = "Prototype";
          l.add(p);
        }
        {
          Repository p = new Repository();
          p.id = "bootstrap";
          p.repository = "~smith/bootstrap";
          p.lead = "Bob Jones";
          p.commits = 395;
          p.pull_requests = 8;
          p.contributors = 17;
          p.state = "Stable";
          l.add(p);
        }
        {
          Repository p = new Repository();
          p.id = "my-great-project2";
          p.repository = "~smith/my-great-project";
          p.lead = "Steve Smith";
          p.commits = 3;
          p.pull_requests = 4;
          p.contributors = 5;
          p.state = "Stable";
          l.add(p);
        }
        {
          Repository p = new Repository();
          p.id = "my-great-project3";
          p.repository = "~smith/my-great-project";
          p.lead = "Steve Smith";
          p.commits = 3;
          p.pull_requests = 4;
          p.contributors = 5;
          p.state = "Stable";
          l.add(p);
        }
        return ok(index.render("Your new application is ready.", l));
    }

}
