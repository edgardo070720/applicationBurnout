# Usa la imagen base de OpenJDK
FROM openjdk:21-jdk

# Crea un directorio para la aplicación
WORKDIR /app

# Copia el archivo JAR del backend al contenedor
COPY target/application-bornout-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8080 (dentro del contenedor)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]

