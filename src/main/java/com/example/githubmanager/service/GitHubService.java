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

    private static final String GITHUB_API_REPOS_URl = "https://api.github.com/users/{username}/repos";
    private static final String GITHUB_API_BRANCHES_URL = "https://api.github.com/repos/{owner}/{repo}/branches";

    public List<GithubRepository> createListOfRepositories(String username) {
        String repositoriesForUser = getRepositoriesForUser(username);
        List<GithubRepository> githubRepositories = GithubRepositoryMapper.githubRepositoriesMapperFromJson(repositoriesForUser);
//        List<Branch> branches = githubRepositories.stream()
//                .forEach(repo -> getBranchesForRepo(repo.ownerLogin(), repo.url_branches()));

//        List<GithubRepository> repositoriesNotFork = repositoriesForUser.stream()
//                .filter(r -> !r.isFork())
//                .toList();
//        List branchesList = repositoriesNotFork
//                .forEach(r -> getBranchesForRepo(r.ownerLogin(), r.url_branches()));

        return githubRepositories;
    }

    public String getRepositoriesForUser(String username) {
        String uri = UriComponentsBuilder.fromUriString(GITHUB_API_REPOS_URl)
                .buildAndExpand(username)
                .toString();
       return restTemplate.getForObject(uri, String.class);

    }

    public String getBranchesForRepo(String owner, String repo) {
        String uri = UriComponentsBuilder.fromUriString(GITHUB_API_BRANCHES_URL)
                .buildAndExpand(owner, repo)
                .toString();
        return restTemplate.getForObject(uri, String.class);

    }
}
