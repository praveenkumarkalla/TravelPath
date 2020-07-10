## `TravelPath`

TravelPath application determines if two cities are connected. Two cities are considered
connected if there’s a series of roads that can be traveled from one city to another.

A rest api is exposed which determines the possible path between two cities. If path exists then return "Yes" or "No" in response


#### `Technologies`
Spring Boot 2.0,<br>
Java 1.8 <br>
Maven <br>
Mockito for Unit testing. 

####`Implementation Steps`

After analyzing  the requirement, it is considered to use Graph data structure to compute the path between two cities where they are not directly connected


1. Given a text file consists of pair of cities in each line. The file is placed in below path.
    - \resources\cities.txt
2. Config file ReadCitiesFromFile.java reads the textfile and places all the cities in Graph data structure
    - \src\main\java\com\flights\path\config\ReadCitiesFromFile.java
3. Graph.java is used to construct a graph for the given cities and Search.java is used to traverse the graph in DFS(Depth First Search) algorithm.
   - \src\main\java\com\flights\path\util\Graph.java
   - \src\main\java\com\flights\path\util\Search.java
4. An API is exposed through a rest controller web method - findCitiesPath() which takes 2 inputs origin and destination as Query Parameters 
   - \src\main\java\com\flights\path\controller\CitiesPathController.java
5. A service class is invoked from controller which process the inputs and send to Search class for computing the path of the cities.
   - \src\main\java\com\flights\path\services\FindCitiesPathService.java
6. Endpoints - test in postman.
   - http://localhost:8080/connected?origin=Boston&destination=Newark
   - http://localhost:8080/connected?origin=New York&destination=Philadelphia
   - http://localhost:8080/connected?origin=Philadelphia&destination=Trenton
   

####`Unit Testing`

Unit testing carried through Mockito framework, allows the creation of unit tests for the purpose of test-driven development (TDD).
Test cases are cover Only controller class for this project
  - src\test\java\com\flights\path\controller\CitiesPathControllerTest.java
 
 Unit Test classes can run through maven build command or can be execute directly from test class from intellij editor. 
  - />mvn clean install
 
 all the test cases passed.
 

####`Build Status`
  - Success

####`Code repository in GITHUB`

  - https://github.com/praveenkumarkalla/TravelPath
  
####`Installation`

  - Please clone above git repo or download the project zip file from github.
  - NO further config or settings needed.
  - Build the project from terminal 
        \TravelPath> mvn clean install  
    Shows BUILD SUCCESS on project compilation and test classes pass through.
  - To execute the application please run below command from terminal 
        \TravelPath> java -jar target/TravelPath-0.0.1-SNAPSHOT.jar    
   Server will up running on 8080     
        Tomcat started on port(s): 8080 (http) with context path ''<br>
        Started TravelPathApplication in 7.534 seconds (JVM running for 8.751)
        
####`Screenshots For Proof`

   - Screenshots of code snippet, unit test cases execution and api calls through postman are recorded below git document.
   - https://github.com/praveenkumarkalla/TravelPath/blob/master/MC_assignment_screenshots.docx 

