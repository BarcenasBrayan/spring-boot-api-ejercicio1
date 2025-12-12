# ETAPA 1: Compilación (Build)
FROM maven:3-openjdk-17 AS build  
WORKDIR /app
COPY pom.xml .
# Descarga las dependencias para que sean cacheadas
RUN mvn dependency:go-offline
COPY . .
# Compila la aplicación y genera el JAR
RUN mvn clean package -DskipTests

# ETAPA 2: Ejecución (Run)
# Usamos una imagen base más ligera (Alpine) para la ejecución final
FROM openjdk:17-jdk-alpine
# Copia el JAR generado de la etapa de construcción
COPY --from=build /app/target/*.jar app.jar
# Define el punto de entrada (el comando de inicio)
ENTRYPOINT ["java", "-jar", "/app.jar"]