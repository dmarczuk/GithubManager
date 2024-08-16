package com.example.githubmanager.controller;


import com.example.githubmanager.model.GitHubRepositoryResponse;
import com.example.githubmanager.model.GithubRepository;
import com.example.githubmanager.service.GitHubService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class GitHubController {

    private GitHubService gitHubService;

    @GetMapping(value = "/repos/{username}", produces = "application/json")
    public ResponseEntity<List<GitHubRepositoryResponse>> getRepositories(@RequestHeader(value = "Accept", required = false) @PathVariable String username) {
        List<GitHubRepositoryResponse> repositories = gitHubService.createListOfRepositories(username);
        return ResponseEntity.ok(repositories);
    }
}
