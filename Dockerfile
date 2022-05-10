FROM openjdk:11
ADD target/virtuallab.jar virtuallab.jar
EXPOSE 9091
ENTRYPOINT ["java", "-jar", "virtuallab.jar"]
