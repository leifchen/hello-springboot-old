# Hello-SpringBoot

整理常用 Spring Boot 相关的知识内容。

## 热部署

### 1. 添加依赖项

```groovy
implementation('org.springframework.boot:spring-boot-devtools')
``` 

### 2. 在配置文件 application.yml 配置以下属性

```yaml
spring
  devtools:
    restart:
      enabled: true
      additional-paths: src/main/java

  thymeleaf:
    cache: false
```    

## 多环境配置

- 配置开发环境：application-dev.yml
- 配置正式环境：application-prd.yml

借由配置文件 application.yml 中的 spring.profiles.active=dev 来实现环境的选择。

## 集成 MyBatis + 通用 Mapper

详情请参考[abel533/MyBatis-Spring-Boot](https://github.com/abel533/MyBatis-Spring-Boot)的配置说明。

## 邮件发送

### 1. 添加依赖项

```groovy
implementation('org.springframework.boot:spring-boot-starter-mail')
``` 

### 2. 在配置文件 application.yml 配置以下属性

```yaml
spring:
  mail:
    default-encoding: UTF-8
    host: smtp.aliyun.com
    username: user@aliyun.com
    password: password
```

注意替换自己测试邮箱的用户名和密码

## 参考

1. [SpringBoot开发常用技术整合](https://www.imooc.com/learn/956)
2. [Spring Boot进阶之Web进阶](https://www.imooc.com/learn/810)
3. [Spring Boot 2.0深度实践-初遇Spring Boot](https://www.imooc.com/learn/933)
4. [MyBatis-Spring-Boot](https://github.com/abel533/MyBatis-Spring-Boot)
5. [Spring Boot 发送邮件](https://www.imooc.com/learn/1036)