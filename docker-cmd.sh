#!/bin/sh

echo "run java spring boot with profile : ${CONTAINER_ENV}"
echo "set arguments $CONTAINER_ENV environment"

if [ "$CONTAINER_ENV" = "PROD" ]; then
    # set memory limiter for production environment
    XMSLimit="-Xms1024m"
    XMXLimit="-Xmx2048m"
    loggingLevel="INFO"
    echo "masuk ${CONTAINER_ENV} environment"
elif [ "$CONTAINER_ENV" = "UAT" ]; then
	XMSLimit="-Xms512m"
    XMXLimit="-Xmx512m"
    loggingLevel="DEBUG"
elif [ "$CONTAINER_ENV" = "SIT" ]; then
	XMSLimit="-Xms512m"
    XMXLimit="-Xmx512m"
    loggingLevel="DEBUG"
    echo "masuk ${CONTAINER_ENV} environment"
else
    XMSLimit="-Xms512m"
    XMXLimit="-Xmx512m"
    loggingLevel="DEBUG"
fi

echo "done set environment"

java -jar $XMSLimit $XMXLimit -Dspring.profiles.active=$CONTAINER_ENV -Dmaven.test.skip=false /apps/promo-service-*.jar

echo "running"
