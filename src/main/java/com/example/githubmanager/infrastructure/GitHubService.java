package com.example.githubmanager.infrastructure;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Component
public class GitHubService {

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String GITHUB_API_URl = "https://api.github.com/users/{username}/repos";

    public List<Object> getRepositoriesForUser(String username) {
        String uri = UriComponentsBuilder.fromUriString(GITHUB_API_URl)
                .buildAndExpand(username)
                .toString();
        Object[] repositories = restTemplate.getForObject(uri, Object[].class);

        return Arrays.asList(repositories);
    }
}
