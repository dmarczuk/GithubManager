package com.example.githubmanager.model;

import java.util.List;

public record GitHubRepositoryResponse(String repositoryName,
                                       String ownerLogin,
                                       List<Branch> branches) {
}
