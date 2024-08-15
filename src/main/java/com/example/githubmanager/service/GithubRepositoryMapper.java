package com.example.githubmanager.service;

import com.example.githubmanager.model.GithubRepository;
import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public class GithubRepositoryMapper {

    public static GithubRepository mapToGitHubRepository(Object object) {
        Map<String, Object> rawMap = (Map<String, Object>)object;

        return new GithubRepository(
                (String)rawMap.get("name"),
                (String)rawMap.get("full_name"),
                (String)rawMap.get("branches_url"),
                (boolean)rawMap.get("fork")
        );
    }
}
