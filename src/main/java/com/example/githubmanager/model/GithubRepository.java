package com.example.githubmanager.model;

public record GithubRepository(String repositoryName,
                               String ownerLogin,
                               String url_branches,
                               boolean isFork) {
}
