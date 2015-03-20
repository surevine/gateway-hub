package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project extends Model {
    @Id
    public String id;

    public String repository;
    public String lead;
    public int commit_age;
    public int commits;
    public String state;
    public String readme_uri;
    public int pull_requests;
    public int contributors;
}
