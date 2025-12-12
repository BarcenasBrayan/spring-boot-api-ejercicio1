# ---------------------------
# ETAPA 1: BUILD
# ---------------------------
FROM gradle:8.5-jdk17 AS build

WORKDIR /app

# Copia solo lo necesario para el build
COPY build.gradle settings.gradle ./
COPY gradle ./gradle
COPY gradlew ./

# Da permisos de ejecución al wrapper
RUN chmod +x gradlew

# Copia el código fuente
COPY src ./src

# Construye el JAR
RUN ./gradlew bootJar --no-daemon

# ---------------------------
# ETAPA 2: RUN (Imagen ligera)
# ---------------------------
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copia el jar compilado
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
