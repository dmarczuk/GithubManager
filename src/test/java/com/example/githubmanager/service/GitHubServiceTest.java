package com.example.githubmanager.service;

import com.example.githubmanager.model.GitHubRepositoryDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class GitHubServiceTest {

    @Mock
    private RestTemplate restTemplateMock;

    @MockBean
    private GitHubService gitHubServiceMock;

    @Test
    void should_get_all_not_forked_repositories() {
        // given
//        String username = "dmarczuk";
//        String uri = "https://api.github.com/users/dmarczuk/repos"; // This must match the service's generated URI exactly
//
//        // Mock JSON response to simulate GitHub's API response
//        String mockRepositories = "["
//                + "{\"name\": \"Repo1\", \"owner\": {\"login\": \"dmarczuk\"}, \"fork\": false, \"branches_url\": \"url1\"},"
//                + "{\"name\": \"Repo2\", \"owner\": {\"login\": \"dmarczuk\"}, \"fork\": true, \"branches_url\": \"url2\"},"
//                + "{\"name\": \"Repo3\", \"owner\": {\"login\": \"dmarczuk\"}, \"fork\": false, \"branches_url\": \"url3\"}"
//                + "]";
//
//        // Mock the RestTemplate to return the mock JSON when the URI is called
//        Mockito.when(restTemplateMock.getForObject(Mockito.eq(uri), Mockito.eq(String.class)))
//                .thenReturn(mockRepositories);
//
//        // Mock the RestTemplate to return the mock JSON when the URI is called
////        Mockito.when(restTemplateMock.getForObject(uri, String.class))
////                .thenReturn(mockRepositories);
//
//        // when
//        List<GitHubRepositoryDto> listOfRepositories = gitHubServiceMock.createListOfRepositories(username);
//
//        // then
//        Assertions.assertEquals(2, listOfRepositories.size()); // Expecting 2 non-forked repositories

    }

}