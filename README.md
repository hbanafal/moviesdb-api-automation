# moviesdb-api-automation
This project contains api automation framework and tests for themoviedb.org

This assignment is done using Java as programming language, Serenity as Junit wrapper, io.rest-assured Java library.
BDD approach & Single-responsibility principle (SRP) is followed while create the framework. 

Requirements : 
1. Java 1.8+ should be installed on the machine.
2. Gradle should be installed on the machine.

Steps : 
1. Clone the repo using - git clone https://github.com/hbanafal/moviesdb-api-automation.git
2. Go to the root project directory - cd moviesdb-api-automation
3. Run tests using command - ./gradlew clean test
4. Generate Serenity Reports using - ./gradlew aggregate
5. Open report from the path - moviesdb-api-automation/target/site/serenity/index.html
6. Click on Test Results in the report and check the stories and steps involved in the test.

Configuration - /src/test/resources/config.properties contains API Key, BaseURI and Write access token. Currently there is no code to generate Write access token. Please update the write access token and api key if that token expires or doesn't work.  
