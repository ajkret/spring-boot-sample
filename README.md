# spring-boot-sample
Sample (empty) spring-boot-application

Scaffold Maven project with spring-boot. Included BOWER configuration for AngularJS and Bootstrap. Just run the following command on the base folder of the application.

    bower install

## What is implemented
This branch has all the server side classes implemented, running Jersey to resolve the REST services and Spring
Web to test them.

Also implements the Client side using Angular (1.4).

The project aims to follow the guidelines from the following resources:
* https://github.com/johnpapa/angular-styleguide
* https://scotch.io/tutorials/angularjs-best-practices-directory-structure

What needs more work:
* Implement a layer separating business logic and data retrieval
* Use database to store the data
