# Micronaut + GraalVM

## Micronautをインストール

```bash
$ sdk install micronaut 1.2.7

Downloading: micronaut 1.2.7

In progress...

######################################################################## 100.0%

Installing: micronaut 1.2.7
Done installing!


Setting micronaut 1.2.7 as default.

$ mn --version
Resolving dependencies..
| Micronaut Version: 1.2.7
| JVM Version: 1.8.0_232
```

## Micronautアプリの作成

```
$ mn create-app com.example.hello
| Generating Java project...
| Application created at /path/hello
```

## GraalVM を SDKMAN でインストール

インストールして、デフォルトは変えない。 use で変更

```
$ sdk install java 19.2.1-grl

Installing: java 19.2.1-grl
Done installing!

Do you want java 19.2.1-grl to be set as default? (Y/n): n
$ sdk use java 19.2.1-grl
$ java -version
openjdk version "1.8.0_232"
OpenJDK Runtime Environment (build 1.8.0_232-20191009173705.graal.jdk8u-src-tar-gz-b07)
OpenJDK 64-Bit GraalVM CE 19.2.1 (build 25.232-b07-jvmci-19.2-b03, mixed mode)
```

## GraalVM 用 Micronautアプリの作成

```
$ mn create-app hello-graal --features graal-native-image
| Generating Java project...
| Application created at /path/hello-graal
```

## native-image を作成

```
$ ./gradlew assemble
$ native-image --no-server -cp build/libs/hello-graal-0.1-all.ja
```

## 参考
- [Micronaut Guide](https://guides.micronaut.io/index.html)
- [Micronautフレームワークを使ってみよう](https://dev.classmethod.jp/server-side/java/micronaut-start/)
- [JVMベースのMicroservices用フルスタックフレームワークMicronautを試してみる](https://qiita.com/nobeans/items/2d07067d15c0cb5b64e5)
- [MicronautでGraalVM native imageを動かす](https://dev.classmethod.jp/etc/micronaut-graalvm/)