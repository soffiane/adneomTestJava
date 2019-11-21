#Test Java Adneom

The goal of this project is to develop a function that split a list into n list of size element

For instance :

partition([1,2,3,4,5], 2) returns: [ [1,2], [3,4], [5] ] 
partition([1,2,3,4,5], 3) returns: [ [1,2,3], [4,5] ] 
partition([1,2,3,4,5], 1) returns: [ [1], [2], [3], [4], [5] ] 

#To get started

    check out or clone the project on GitHub
    generate the .jar with the maven command : mvn package
    launch the generated jar with command : java -jar "list" "size" testJava-1.0-SNAPSHOT.jar
    
    "list" is the list you want to split and "size" param is the max size of the lists you want
    both parameters are strings
    
    example : 
    $ java -jar testJava-1.0-SNAPSHOT.jar [1,2,3,4,5] 2
    [[1, 2], [3, 4], [5]]
    
    also works without brackets
    $ java -jar testJava-1.0-SNAPSHOT.jar 1,2,3,4,5 2
    [[1, 2], [3, 4], [5]]


#Built With

    Maven (https://maven.apache.org/) - Dependency Management
    Junit4 (https://junit.org/junit4/) - Unit Test Framework

#Versioning

For the versions available, see my github(https://github.com/soffiane/adneomTestJava).

#Authors

Soffiane Boudissa - Initial work - https://github.com/soffiane)
