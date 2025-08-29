# -------- Stage 1: Build --------
FROM eclipse-temurin:24-jdk AS build

WORKDIR /app

# Install Maven (Debian-based)
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Copy project files
COPY pom.xml .
COPY src ./src

# Build jar
RUN mvn clean package -DskipTests

# -------- Stage 2: Run --------
FROM eclipse-temurin:24-jre AS run

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080

## Environment variables
#ENV SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/khana_khazana
#ENV SPRING_DATASOURCE_USERNAME=postgres
#ENV SPRING_DATASOURCE_PASSWORD=mysecretpassword
#ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update
#ENV SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT=org.hibernate.dialect.PostgreSQLDialect
#ENV SPRING_JPA_SHOW_SQL=true

ENTRYPOINT ["java","-jar","app.jar"]
