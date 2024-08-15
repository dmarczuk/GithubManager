package com.example.githubmanager.service;

import com.example.githubmanager.model.Branch;
import com.example.githubmanager.model.GithubRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GitHubService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final String GITHUB_API_REPOS_URl = "https://api.github.com/users/{username}/repos";
    private static final String GITHUB_API_BRANCHES_URL = "https://api.github.com/repos/{owner}/{repo}/branches";

    public List<GithubRepository> createListOfRepositories(String username) {
        List<GithubRepository> repositoriesForUser = getRepositoriesForUser(username);

        return repositoriesForUser;
    }

    public List<GithubRepository> getRepositoriesForUser(String username) {
        String uri = UriComponentsBuilder.fromUriString(GITHUB_API_REPOS_URl)
                .buildAndExpand(username)
                .toString();
        Object[] repositories = restTemplate.getForObject(uri, Object[].class);

        return Arrays.stream(repositories)
                .map(GithubRepositoryMapper::mapToGitHubRepository)
                .collect(Collectors.toList());
    }

    public List<Branch> getBranchesForRepo(String owner, String repo) {
        String uri = UriComponentsBuilder.fromUriString(GITHUB_API_BRANCHES_URL)
                .buildAndExpand(owner, repo)
                .toString();
        Object[] branches = restTemplate.getForObject(uri, Object[].class);

        return Arrays.stream(branches)
                .map(object -> objectMapper.convertValue(object, Branch.class))
                .collect(Collectors.toList());
    }
}
