FROM gradle:jdk17-alpine
WORKDIR /building-sync-service

COPY src /building-sync-service/src/
COPY build.gradle .
COPY lombok.config .

RUN gradle clean build -x test

ENTRYPOINT ["java", "-jar", "./build/libs/building-sync-service-1.0.0.jar"]