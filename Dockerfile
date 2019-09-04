FROM openjdk:8-slim
LABEL maintainer="yortsros@gmail.com"
VOLUME /tmp
EXPOSE 1234
ARG JAR_FILE=target/spring-boot-mybatis-swagger-h2-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} spring-boot-mybatis-swagger-h2-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-boot-mybatis-swagger-h2-0.0.1-SNAPSHOT.jar"]
