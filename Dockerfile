FROM maven:3-openjdk-17 as build-image
WORKDIR /to-build-app
COPY . .
RUN mvn install
RUN ./mvnw clean package

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build-image /to-build-app/target/*.jar /app/app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]