# Etapa 1: Construcción de la aplicación
FROM maven:3.9.4-eclipse-temurin-21 AS builder

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml y las dependencias
COPY pom.xml .

# Descarga las dependencias (esto se cacheará)
RUN mvn dependency:go-offline

# Copia el resto del código fuente de la aplicación
COPY src ./src

# Compila y construye la aplicación
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final (ejecución de la aplicación)
FROM openjdk:21-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo jar generado desde la etapa anterior
COPY --from=builder /app/target/application-bornout-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto de la aplicación
EXPOSE 8080

# Crea un usuario no root para ejecutar la aplicación
RUN groupadd -g 1001 appgroup && useradd -u 1001 -g appgroup appuser
USER appuser

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]