# Ejecuta la suite contra Selenium Grid. El navegador vive en el servicio selenium.
FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY gradlew settings.gradle build.gradle ./
COPY gradle ./gradle
RUN chmod +x gradlew && ./gradlew --version --no-daemon

COPY src ./src

CMD ["./gradlew", "test", "--no-daemon"]
