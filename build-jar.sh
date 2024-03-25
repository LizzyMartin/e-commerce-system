#!/bin/bash

# This script is used to build the jar file for the project
./auth/gradlew -p ./auth clean build
./items-management/gradlew -p ./items-management clean build
./cart/gradlew -p ./cart clean build
