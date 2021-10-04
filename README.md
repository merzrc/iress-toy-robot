# Toy Robot Code Challenge

A console application for simulating toy robot.

## System Requirements

To checkout, build and use this project, you will need the following tools on your local machine:

- Git (Version 2)
- Java 8

## Quick Start

To clone, checkout the development branch and run a build (assuming calls started from top level workspace):

```
git clone https://github.com/merzrc/iress-toy-robot.git

cd iress-toy-robot

git checkout master

./gradlew clean build
```

## Configuration

The application uses Spring Boot configuration - CommandLineRunner interface to launch.

## Running

### Command Line

```
./gradlew bootRun
```

### Eclipse

First build the Eclipse project files:

```
./gradlew cleanEclipse eclipse
```

Within Eclipse, use File > Import and select Import Existing Project into Workspace.

Once the import is complete, the main class can be run or debugged:

```
com.iress.codechallenge.Application.java

```

## Project Structure

The project has the following structure:

```
README.md                           -- This readme help file
build.gradle                        -- Main gradle build file
gradlew                             -- Gradle wrapper executable
gradlew.bat                         -- Gradle wrapper batch executable for Windows
.gitignore                          -- Git ignore
gradle/
  wrapper/
    gradle-wrapper.jar              -- Gradle wrapper executable JAR
    gradle-wrapper.properties       -- Gradle wrapper properties
src/
  main/
    java/                           -- Main Java source
    resources/                      -- Main application resources
  test/
    java/                           -- Unit test Java source
  functional/
    java/                           -- Functional test Java source
```

## Application Properties

The application makes use of the Spring Boot properties. Application specific properties are the following:

```
# Application
application
  description                      -- Text description of the application

# Console Application Property
spring
  main                             
  web-application-type             -- This property will explicitly inform Spring that this isn't a web application.

```


