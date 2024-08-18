# GitHubManager

## About project
Spring Boot application that lists non-forked GitHub repositories 
for a given user, including branch and last commit information. Next methods
could be implemented in the future.

## Main responsibilities application
<ul>
<li>Get list of repositories for given user</li>
</ul>

## Usage:

### Endpoints
- `GET /api/github/user/{username}/repos` - Fetches all non-forked repositories for a given GitHub username, including branch and last commit details.

### Postman screenshots:
Screenshot of method GET /api/github/user/dmarczuk/repos which return list of not forked repositories for user dmarczuk
![ListOfNotForkedRepositories.jpg](ListOfNotForkedRepositories.jpg)
Screenshot of method GET /api/github/user/dmarczukXXX/repos which return error response, because user not found
![ResponseWhenUserNotFound.jpg](ResponseWhenUserNotFound.jpg)
## Technologies used in project

Code: <br>
![Static Badge](https://img.shields.io/badge/java_17-orange?style=for-the-badge&logo=openjdk&logoColor=white)  
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)  
![Maven](https://img.shields.io/badge/maven-%23DD0031.svg?style=for-the-badge&logo=apachemaven&logoColor=white)  
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)

Test: <br>
![Test](https://img.shields.io/badge/Junit5-94BA3B?style=for-the-badge&logo=Junit5&logoColor=white)
![Test](https://img.shields.io/badge/Mockito-1FC72F?style=for-the-badge&logo=mockito&logoColor=white)
<br>

## Installation and run

#### Requirements:



#### Installation:


#### Configuration:

#### Running the Application:


## In future

