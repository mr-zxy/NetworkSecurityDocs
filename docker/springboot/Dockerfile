FROM openjdk:8-jdk-alpine
RUN mkdir -p /dockerServer/java   
WORKDIR /dockerServer/java       
COPY *.jar /dockerServer/java/framework.jar
EXPOSE 8080     
ENTRYPOINT ["java","-jar","/framework.jar",">>","/dockerServer/java/register.log 2>&1","&"]
