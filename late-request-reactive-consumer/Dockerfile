FROM openjdk:8-jdk-alpine
WORKDIR /opt/app
COPY /.mvn ./.mvn
COPY pom.xml mvnw  ./
RUN ./mvnw dependency:go-offline
COPY /src ./src
RUN ./mvnw clean package -DskipTests -DfinalName=app
ENTRYPOINT ["java","-jar","target/app.jar"]