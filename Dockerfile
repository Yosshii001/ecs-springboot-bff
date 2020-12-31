

 FROM maven:3.6.3-openjdk-11 as build-env

RUN git clone https://github.com/Yosshii001/ecs-springboot-bff.git \
 /var/local/ecs-springboot-bff

RUN mvn install -DskipTests=true -f /var/local/ecs-springboot-bff/pom.xml

FROM openjdk:11.0.9.1-jre
COPY --from=build-env \
 /var/local/ecs-springboot-bff/target/ecs-springboot-bff-0.0.1-SNAPSHOT.jar \
 /var/local/ecs-springboot-bff/ecs-springboot-bff-0.0.1-SNAPSHOT.jar

MAINTAINER junichi02
EXPOSE 8081

CMD java -jar -Dspring.profiles.active=production \
 /var/local/ecs-springboot-bff/ecs-springboot-bff-0.0.1-SNAPSHOT.jar
