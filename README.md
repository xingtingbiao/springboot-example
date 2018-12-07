# springboot-example

maven:多环境配置
参考: http://www.cnblogs.com/zeng1994/p/06917ed3b98677fa7a1b0f74de16c3be.html
mvn clean package -Dmaven.test.skip=true -Psit
java -jar xxx.jar --spring.profiles.active=test 表示使用测试环境的配置

gradle:多环境配置
./gradlew clean build -Dprofile=sit
参考: https://blog.csdn.net/liwgdx80204/article/details/80942440