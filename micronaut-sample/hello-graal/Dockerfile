FROM oracle/graalvm-ce:19.2.1 as graalvm
COPY . /home/app/hello-graal
WORKDIR /home/app/hello-graal
RUN gu install native-image
RUN native-image --no-server -cp build/libs/hello-graal-*-all.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/hello-graal .
ENTRYPOINT ["./hello-graal"]
