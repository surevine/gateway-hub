package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import models.*;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    public static Result index() {
        List<Project> l = new ArrayList<Project>();
        {
          Project p = new Project();
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
          Project p = new Project();
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
          Project p = new Project();
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
          Project p = new Project();
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
