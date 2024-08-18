package com.example.githubmanager.service;

import com.example.githubmanager.exception.UsernameNotFoundException;
import com.example.githubmanager.model.Branch;
import com.example.githubmanager.model.GitHubRepositoryDto;
import com.example.githubmanager.model.GithubRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Component
public class GitHubService {

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String GITHUB_API_REPOS_URl = "https://api.github.com/users/{username}/repos";
    private static final String GITHUB_API_BRANCHES_URL = "https://api.github.com/repos/{owner}/{repo}/branches";

    public List<GitHubRepositoryDto> createListOfRepositories(String username) {
        String repositoriesForUser = getRepositoriesForUser(username);
        List<GithubRepository> githubRepositories = JsonMapper.githubRepositoriesMapperFromString(repositoriesForUser);
        List<GitHubRepositoryDto> gitHubRepositoryResponseList = new ArrayList<>();
        for(GithubRepository repo: githubRepositories) {
            String branchesForRepo = getBranchesForRepo(repo.ownerLogin(), repo.repositoryName());
            List<Branch> branches = JsonMapper.githubBranchesMapperFromString(branchesForRepo);
            GitHubRepositoryDto gitHubRepositoryResponse = new GitHubRepositoryDto(repo.repositoryName(), repo.ownerLogin(), branches);
            gitHubRepositoryResponseList.add(gitHubRepositoryResponse);
        }
        return gitHubRepositoryResponseList;
    }

    public String getRepositoriesForUser(String username) {
        String uri = UriComponentsBuilder.fromUriString(GITHUB_API_REPOS_URl)
                .buildAndExpand(username)
                .toString();
        try {
            return restTemplate.getForObject(uri, String.class);
        } catch (Exception e) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

    }

    private String getBranchesForRepo(String owner, String repo) {
        String uri = UriComponentsBuilder.fromUriString(GITHUB_API_BRANCHES_URL)
                .buildAndExpand(owner, repo)
                .toString();
        return restTemplate.getForObject(uri, String.class);

    }
}
