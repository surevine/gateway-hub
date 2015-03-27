package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Repository extends Model {
    @Id
    public String id;

	private String lead;
    private int commitAge;
    private int commits;
    private String readmeUri;
    private int pullRequests;
    private int contributors;
    private String cloneURL;
    private String repository;
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRepository() {
		return repository;
	}
	public void setRepository(String repository) {
		this.repository = repository;
	}
	public String getLead() {
		return lead;
	}
	public void setLead(String lead) {
		this.lead = lead;
	}
	public int getCommitAge() {
		return commitAge;
	}
	public void setCommitAge(int commitAge) {
		this.commitAge = commitAge;
	}
	public int getCommits() {
		return commits;
	}
	public void setCommits(int commits) {
		this.commits = commits;
	}
	public String getState() {
		if (commits > 10) {
			return "ACTIVE";
		} else {
			return "PROTOTYPE";
		}
	}

	public String getReadmeUri() {
		return readmeUri;
	}
	public void setReadme_uri(String readmeUri) {
		this.readmeUri = readmeUri;
	}
	public int getPullRequests() {
		return pullRequests;
	}
	public void setPullRequests(int pullRequests) {
		this.pullRequests = pullRequests;
	}
	public int getContributors() {
		return contributors;
	}
	public void setContributors(int contributors) {
		this.contributors = contributors;
	}
	public String getCloneURL() {
		return cloneURL;
	}
	public void setCloneURL(String cloneURL) {
		this.cloneURL = cloneURL;
	}
}
