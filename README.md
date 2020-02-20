# #0. Rest api with spring boot
<br/>

* [Start width Gradle Project](#start-with-gradle-project)
* [Start with SpringInitializr](#start-with-springInitializr)
  
<br/>

#### Start with Gradle Project
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
    ```java
   // BoardController.class
   
    package io.cloudrium.sample.board.api.controller;
    
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
    
    @RestController
    @RequestMapping("/boards")
    public class BoardController {
    
        @GetMapping
        public ResponseEntity get() {
            return ResponseEntity.ok("test!");
        }
    
    }
    ```          
        
5) Run application
    - call GET /boards api 

<br/>
<br/>

#### Start with SpringInitializr
1) Spring intializr(https://start.spring.io) 웹 사이트에서 아래와 같이 설정된 프로젝트 다운로드
    
    | Ttitle  | Value |
    |------|---|
    | `Project`  | Gradle Project |
    | `Language` | Java | 
    | `Spring Boot` | 2.2.4 | 
    | `Dependencies` | Spring Web | 

<br/>

* ref. 이후 과정은 __[Start with Gradle Project](#start-with-gradle-project)__의 5,6,7 참고
