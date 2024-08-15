package com.example.githubmanager.model;

import java.util.List;

public record GithubRepository(String repositoryName,
                               String ownerLogin,
                               String url_branches,
                               boolean isFork) {
}
