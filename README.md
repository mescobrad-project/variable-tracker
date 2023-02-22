# Variable Tracker

![REPO-TYPE](https://img.shields.io/badge/repo--type-backend-critical?style=for-the-badge&logo=github)

A microservice used to track similar variables from Metadata Manager.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

* Java 17
* Maven 3.6.3
* Metadata Manager with data

### Installing

#### Kubernetes (remotely)

If you use a remote instance of Kubernetes you can start Variable Tracker simply through docker compose.

To start it on your local development environment, do the following steps:

- Checkout the code from this repository

```
 git clone https://github.com/mescobrad-project/variable-tracker
 ```
 
 - Move into checked out folder and compile the code

```
cd variable-tracker

mvn clean install
```
- Configure the environment variables: add variable (variable.host) pointing to the host of Metadata Manager.
- Run the application through docker compose

```
cd docker

docker-compose up
```
## Usage

Application accepts POST request to path /variables which must include 3 parameters:
- variableName -> part of the name of the variable to check against
- categoryName -> part of the name of the category to check against
- dataType -> data type to check against

## Running the tests

Launch `mvn test` to execute the unit tests

## Built With

* [SpringBoot](http://springboot.io) - The Java framework used
* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](tags). 

## Authors

* **Igor Molnar** - *Initial work* - [imolnar92](https://github.com/imolnar92)
* **Antonino Sirchia** - *Team Lead* - [sirnino](https://github.com/sirnino)
