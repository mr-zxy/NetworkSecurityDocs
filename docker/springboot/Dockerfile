FROM openjdk:8-jdk-alpine
RUN mkdir -p /home/java   
WORKDIR /home/java      
VOLUME /home/java 
COPY *.jar /home/java/framework.jar
COPY ip2region.db /home/java/ip2region.db
EXPOSE 8080     
ENTRYPOINT ["java","-jar","/home/java/framework.jar"]