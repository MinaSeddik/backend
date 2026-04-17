#!/usr/bin/env bash

set -a
source ./.env
set +a

./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
