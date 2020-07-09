# TravelPath

This project provides rest api which determines the possible path between to cities. If path exists then return "Yes" or "No" in response

1. A text file contains cities for which path has to determined
    - \resources\cities.txt
2. Config file ReadCitiesFromFile.java reads the textfile and places all the cities in Graph data structure
    - \src\main\java\com\flights\path\config\ReadCitiesFromFile.java
3. Graph.java is used to construct a graph for the given cities and Search.java is used to traverse the graph in DFS(Depth First Search) algorithm.
   - \src\main\java\com\flights\path\util\Graph.java
   - \src\main\java\com\flights\path\util\Search.java
4. Endpoints - http://localhost:8080/connected?origin=Boston&destination=Newark
   - \src\main\java\com\flights\path\controller\CitiesPathController.java
5. Unit test class are only defined for Controller classes and are present in test folder.
