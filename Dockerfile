FROM openjdk:8-alpine

# temp activated user root
#-----------------------------------------------------
USER root

# copy source project..
#-----------------------------------------------------
COPY ./target/*.jar /apps/ 
COPY ./docker-cmd.sh /apps/

RUN mkdir -p -- /apps/logs
RUN chmod +x /apps/*.sh && \
    chown -Rf 3000.3000 /apps

# Set Non Root User
#-----------------------------------------------------
USER 3000

# expose service port
#-----------------------------------------------------
EXPOSE 8080

# Run Service
#-----------------------------------------------------
CMD /apps/docker-cmd.sh