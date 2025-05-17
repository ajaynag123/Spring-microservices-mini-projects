    # Use Java 23 base image
    FROM openjdk:23-jdk

    # Set working directory
    WORKDIR /app

    # Copy the built JAR from target/ (built with mvn clean package)
    COPY target/user-service-0.0.1-SNAPSHOT.jar .


    # Expose port 8080 (Spring Boot default)
    EXPOSE 8080

    # Run the JAR with profile support (default to prod)
    ENTRYPOINT ["java", "-jar", "user-service-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod"]