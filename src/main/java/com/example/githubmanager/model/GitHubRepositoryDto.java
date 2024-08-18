package com.example.githubmanager.model;

import java.util.List;

public record GitHubRepositoryDto(String repositoryName,
                                  String ownerLogin,
                                  List<Branch> branches) {
}
