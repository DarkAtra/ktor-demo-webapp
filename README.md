# ktor-demo-webapp

A tiny demo application that uses ktor to serve server side rendered web pages.
It also supports native compilation using GraalVM.

## Building the application

```
mvn clean package
```

The resulting jars can be found in the `target` directory.

```
java -jar ./target/ktor-demo-webapp-0.0.1-jar-with-dependencies.jar
```

The web page should respond at http://localhost:8080.

## Building the native image

Ensure that you're using a JDK that supports native image compilation ([such as GraalVM](https://www.graalvm.org/latest/docs/getting-started/)).

```
mvn -Pnative clean package
```

The resulting executable can be found in the `target` directory.

```
./target/ktor-demo-webapp
```

The web page should respond at http://localhost:8080.
