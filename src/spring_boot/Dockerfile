FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/gs-profile-sample-rs.jar gs-profile-sample-rs.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /gs-profile-sample-rs.jar" ]
