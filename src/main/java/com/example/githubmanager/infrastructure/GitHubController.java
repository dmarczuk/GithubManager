package com.example.githubmanager.infrastructure;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class GitHubController {

    private GitHubService gitHubService;

    @GetMapping("/repos/{username}")
    public ResponseEntity<List<Object>> getRepositories(@PathVariable String username) {
        List<Object> repositories = gitHubService.getRepositoriesForUser(username);
        return ResponseEntity.ok(repositories);
    }
}
