FROM oracle/graalvm-ce:19.3.0-java8 as graalvm
#FROM oracle/graalvm-ce:19.3.0-java11 as graalvm # For JDK 11
COPY . /home/app/native-rest-api
WORKDIR /home/app/native-rest-api
RUN gu install native-image
RUN native-image --no-server --static -cp build/libs/native-rest-api-*-all.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/native-rest-api/native-rest-api /app/native-rest-api
ENTRYPOINT ["/app/native-rest-api", "-Djava.library.path=/app"]
