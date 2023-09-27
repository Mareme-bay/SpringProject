

FROM openjdk:22-jdk-slim
VOLUME /tmp
EXPOSE 9002
ADD target/wallet-0.0.1-SNAPSHOT.jar projetSpring.jar
ENTRYPOINT ["java","-jar","/projetSpring.jar"]



