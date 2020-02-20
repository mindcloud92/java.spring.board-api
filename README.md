# #0. Rest api with spring boot(gradle project)

<br/>
<br/>

> spring initialzr(https://start.spring.io/)로 다운받을 경우의 설정은 아래와 같다.  
Project | Gradle Project
--- | --- | ---
Language | Java
--- | --- | ---
Spring Boot | 2.2.4
--- | --- | ---
Dependencies | Spring Web

<br/>

1) create gradle project  

2) modify build.gradle  
    - define spring boot plugin & spring boot starter web dependency
        ```gradle
      // build.gradle
      
        plugins {
            id 'org.springframework.boot' version '2.2.4.RELEASE'
            id 'io.spring.dependency-management' version '1.0.9.RELEASE'
            ...
        }
        
        dependencies {
            implementation 'org.springframework.boot:spring-boot-starter-web'
            ...        
        }
        ```  
        
    - change group
        ```gradle
      // build.gradle
      
        group 'group'
        ```    
    
3) add application class & write code        
    ```java
   // Application.class
   
   package io.cloudrium.sample.board.api;
   
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   
   
   @SpringBootApplication
   public class Application {
   
       public static void main(String[] args) {
           SpringApplication.run(Application.class, args);
       }
   
   }
    ```
   
    - Optional) set up server port to application.yml
    ```yaml
   # application.yml
   
   server:
       port: 80
    ```  
   
4) add controller package & BoardController class          
        
5) Run application
    - call GET /boards api 
