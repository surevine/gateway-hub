package com.surevine.community.hub.stash;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import models.Repository;

import com.surevine.gateway.scm.model.LocalRepoBean;
import com.surevine.gateway.scm.scmclient.GetRepoCommand;
import com.surevine.gateway.scm.scmclient.SCMCallException;
import com.surevine.gateway.scm.scmclient.stash.StashCommandFactory;
import com.typesafe.config.ConfigFactory;

public class StashApiClient {

	public static final String API_BASE_URL = ConfigFactory.load().getString("stash.api.base.url");

	public static List<Repository> loadRepositoriesForProject(String projectName) {

		GetRepoCommand getRepoCommand = new StashCommandFactory().getGetRepoCommandImpl();

		Collection<LocalRepoBean> repoBeans = null;
		try {
			repoBeans = getRepoCommand.getRepositories(projectName);
		} catch (SCMCallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Repository> repositories = new ArrayList<Repository>();

		if(repoBeans != null) {
			Iterator<LocalRepoBean> it = repoBeans.iterator();
			while(it.hasNext()) {
				LocalRepoBean repoBean = it.next();
				Repository repository = new Repository();
				repository.repository = repoBean.getProjectKey() + "/" + repoBean.getSlug();
				repositories.add(repository);
			}
		}

		return repositories;
	}

	public Repository getRepository(String projectName, String repoName) {

		GetRepoCommand getRepoCommand = new StashCommandFactory().getGetRepoCommandImpl();

		LocalRepoBean repoBean = null;
		try {
			repoBean = getRepoCommand.getRepository(projectName, repoName);
		} catch (SCMCallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Repository repository = new Repository();

		if(repoBean != null) {
			repository.repository = repoBean.getProjectKey() + "/" + repoBean.getSlug();
		}

		return repository;
	}



}
