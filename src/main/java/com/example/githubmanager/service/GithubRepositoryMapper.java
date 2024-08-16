package com.example.githubmanager.service;

import com.example.githubmanager.model.GithubRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Builder
public class GithubRepositoryMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<GithubRepository> githubRepositoriesMapperFromJson(String json) {
        List<GithubRepository> githubRepositories = new ArrayList<>();
        try {
            JsonNode rootNode = objectMapper.readTree(json);

            for(JsonNode repoNode: rootNode) {
                String name = repoNode.path("name").asText();
                String owner = repoNode.path("owner").path("login").asText();
                String url_branches = repoNode.path("branches_url").asText();
                boolean isFork = repoNode.path("fork").asBoolean();
                GithubRepository githubRepository = new GithubRepository(name, owner, url_branches, isFork);
                githubRepositories.add(githubRepository);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // message can read json
        }
        return githubRepositories;
    }
}
