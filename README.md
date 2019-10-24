# graphql-api-cxf-springboot

** Please note it is a Work-in-Progress project **

A GraphQL API gateway built with serverless and microservice patterns with REST API based on CXF/Spring-boot.

It is to cater for exposing customer self-service using a GraphQL API gateway in serverless patterns for clients accessing from web applications or mobile applications.

The design goals are:

  * Build Low Latency API to serve complex, high dimensional dataset

  * Using a single query, return a nested response from multiple data sources

  * Build an api gateway to securely aggregate data with high performance

  * Build with severless and microservices patterns

## To run the spring boot application


    $ cd ./src/spring_boot
    $ mvn package
    $ mvn dockerfile:build

Run the container:

    $ docker run -p 8080:8080 -t ${username}/apachecxf:gs-profile-sample-rs


## api definition and try it out in Swagger UI

http://localhost:8080/services/helloservice/openapi.json will return a Swagger JSON
description of services.

or visit the Swagger UI at
http://localhost:8080/services/helloservice/api-docs?url=/services/helloservice/openapi.json

### TO DO

  * convert the data format from xml to json