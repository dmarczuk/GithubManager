package com.example.githubmanager.service;

import com.example.githubmanager.model.Branch;
import com.example.githubmanager.model.GithubRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class JsonMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<GithubRepository> githubRepositoriesMapperFromString(String repositoriesString) {
        List<GithubRepository> githubRepositories = new ArrayList<>();
        try {
            JsonNode rootNode = objectMapper.readTree(repositoriesString);

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
        }
        return githubRepositories;
    }

    public static List<Branch> githubBranchesMapperFromString(String branchesString) {
        List<Branch> branchList = new ArrayList<>();
        try {
            JsonNode rootNode = objectMapper.readTree(branchesString);

            for(JsonNode branchNode: rootNode) {
                String name = branchNode.path("name").asText();
                String lastCommitSHA = branchNode.path("commit").path("sha").asText();
                Branch branch = new Branch(name, lastCommitSHA);
                branchList.add(branch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return branchList;
    }
}
