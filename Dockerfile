# our base build image
FROM maven:3.8.6-jdk-11 as maven

# copy the project files
COPY ./pom.xml ./pom.xml

# build all dependencies
RUN mvn dependency:go-offline -B

# copy your other files
COPY ./src ./src

# build for release
RUN mvn package -DskipTests

# our final base image
FROM eclipse-temurin:11.0.17_8-jre

# set deployment directory
WORKDIR /my-project

# copy over the built artifact from the maven image
COPY --from=maven target/carshop-1.0.0.jar ./

# set the startup command to run your binary
CMD ["java", "-jar", "./carshop-1.0.0.jar"]