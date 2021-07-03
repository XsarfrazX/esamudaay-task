#!/bin/bash

# npm install @openapitools/openapi-generator-cli -g
OPENAPI_GENERATOR_VERSION=3.0.0 openapi-generator-cli generate \
    -g spring \
    --library spring-boot \
    -i api-spec.yml \
    -o ${PWD} \
    -p groupId=com.sarfraz \
    -p artifactId=task \
    -p artifactVersion=0.0.1 \
    -p basePackage=com.sarfraz.task \
    -p configPackage=com.sarfraz.task.config \
    -p apiPackage=com.sarfraz.task.api \
    -p modelPackage=com.sarfraz.task.model \
    -p sourceFolder=src/main/gen \
    -p dateLibrary=java8 \
    -p java8=true \
    # --skip-validate-spec
