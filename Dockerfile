FROM openjdk:11
ADD target/carServiceApp.jar carServiceApp.jar
EXPOSE 8557
ENTRYPOINT ["java", "-jar", "carServiceApp.jar"]