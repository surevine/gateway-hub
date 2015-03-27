package com.surevine.community.hub.metastats;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {

	private String name;
	private String fetchUrl;
	private int numFiles;
	private int numContributors;

	private int linesOfCode;
	private int numCommits;

	private List<TopContributor> topContributors = new ArrayList<TopContributor>();

	public List<TopContributor> getTopContributors() {
		return topContributors;
	}

	public void setTopContributors(List<TopContributor> topContributors) {
		this.topContributors = topContributors;
	}

	public int getLinesOfCode() {
		return linesOfCode;
	}

	public void setLinesOfCode(int linesOfCode) {
		this.linesOfCode = linesOfCode;
	}

	public int getNumCommits() {
		return numCommits;
	}

	public void setNumCommits(int numCommits) {
		this.numCommits = numCommits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFetchUrl() {
		return fetchUrl;
	}

	public void setFetchUrl(String fetchUrl) {
		this.fetchUrl = fetchUrl;
	}

	public int getNumFiles() {
		return numFiles;
	}

	public void setNumFiles(int numFiles) {
		this.numFiles = numFiles;
	}

	public int getNumContributors() {
		return numContributors;
	}

	public void setNumContributors(int numContributors) {
		this.numContributors = numContributors;
	}

	public String getLeadContributor() {

		int max = 0;
		String topContrib = null;

		if (!topContributors.isEmpty()) {
			for (TopContributor contrib : topContributors) {
				if (contrib.getNumCommits() > max) {
					topContrib = contrib.getName();
				}
			}

		}
		
		return topContrib;

	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	static class TopContributor {

		public TopContributor() {
			
		}
		
		private String name;
		private int numCommits;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getNumCommits() {
			return numCommits;
		}

		public void setNumCommits(int numCommits) {
			this.numCommits = numCommits;
		}

	}
}
