package com.example.githubmanager.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class GitHubServiceTest {

    @Mock
    private RestTemplate restTemplateMock;

    @Autowired
    private GitHubService gitHubServiceMock;

    @Test
    void should_get_all_not_forked_repositories() {
        // given
//        String username = "someUser";
//        String uri = "https://api.github.com/users/someUser/repos";
//
//        String mockRepositories = "["
//                + "{\"name\": \"Repo1\", \"owner\": {\"login\": \"someUser\"}, \"fork\": false, \"branches_url\": \"url1\"},"
//                + "{\"name\": \"Repo2\", \"owner\": {\"login\": \"someUser\"}, \"fork\": true, \"branches_url\": \"url2\"},"
//                + "{\"name\": \"Repo3\", \"owner\": {\"login\": \"someUser\"}, \"fork\": false, \"branches_url\": \"url3\"}"
//                + "]";
//
//        Mockito.when(restTemplateMock.getForObject(Mockito.eq(uri), Mockito.eq(String.class)))
//                .thenReturn(mockRepositories);
//
////        Mockito.when(restTemplateMock.getForObject(uri, String.class))
////                .thenReturn(mockRepositories);
//
//        // when
//        List<GitHubRepositoryDto> listOfRepositories = gitHubServiceMock.createListOfRepositories(username);
//
//        // then
//        Assertions.assertEquals(2, listOfRepositories.size());
    }

    @Test
    void should_return_error_404_when_username_not_found() {
//        String username = "userWhoNotExist";
//        String uri = "https://api.github.com/users/userWhoNotExist/repos";
//
//        Mockito.when(restTemplateMock.getForObject(uri, String.class))
//                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));
//
//        assertThrows(UsernameNotFoundException.class, () -> gitHubServiceMock.getRepositoriesForUser(username));
    }

}