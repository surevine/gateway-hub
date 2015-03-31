package com.surevine.community.hub.stash;

import java.util.ArrayList;
import java.util.List;

import models.Repository;

import com.typesafe.config.ConfigFactory;

public class StashApiClient {

	public static final String API_BASE_URL = ConfigFactory.load().getString("stash.api.base.url");

	public static List<Repository> loadRepositoriesForProject(String projectName) {

		List<Repository> repositories = new ArrayList<Repository>();

		// TODO

		return repositories;
	}

}
