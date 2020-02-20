# #1. Implement CRUD

<br/>

> **_Used:_**  JPA(ORM) + Lombok(lib) + H2 DB

<br/>

* [Start with Gradle Project](#start-with-gradle-project)
* [Start with SpringInitializr](#start-with-springInitializr)
  
<br/>

#### Start with Gradle Project

1) connect Database        
    - change build.gradle        
        - define dependency  
        
        ```gradle
        // build.gradle
        
        dependencies {
            runtimeOnly 'com.h2database:h2'
            ...
        }
        ```    
        
    -  set up database setting to application.yml
        ```yaml
       # application.yml
       
        spring:
            datasource:
                driver-class-name: org.h2.Driver
                url: jdbc:h2:mem:${my db schema name} 
                usename: sa
                password:
            h2:
                console:
                    enabled: true
                    path: /${my db console path}
        ```

    - access to ${my host}:${my port}/${my db console path}
    
2) set up JPA
    - change build.gradle
        - define dependency  
        ```gradle
        // build.gradle
        
        dependencies {
            implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
            ...
        }
        ```

        optional> set up jpa additional option to application.yml
        ```yaml
        // application.yml      
  
        spring:
            jpa:
                hibernate:
                    ddl-auto: create
                show-sql: true
        ```
        
3) add entity
    - add infrastructure.data package & Board class
    ```java
   // Board.java
   
    package io.cloudrium.sample.board.api.infrastructure.data;
    
   // imports dependencies...
    
    @Entity
    public class Board {
    
        @Id
        @GeneratedValue
        private Long id;
    
        @Column(nullable = false)
        private String title;
    
        @Lob
        @Column(nullable = false)
        private String contents;
    
        @CreationTimestamp
        @Column(nullable = false)
        private LocalDateTime createdAt;
    
        // getter, setter
    }   
    ```
   
4) add respository
    - add infrastructure.repository package & BoardRepository interface
    ```java
    package io.cloudrium.sample.board.api.infrastructure.repository;
    
    // imports dependencies...
    
    public interface BoardRepository extends JpaRepository<Board, Long> {
    }
    ```
   
5) write CRUD logic to Controller
    ```java
    package io.cloudrium.sample.board.api.controller;
    
    // imports dependencies...
    
    @RestController
    @RequestMapping("/boards")
    public class BoardController {
    
        private final BoardRepository repository;
        
        // DI
        public BoardController(BoardRepository repository) {
            this.repository = repository;
        }
    
        @GetMapping
        public ResponseEntity search() {
            return ResponseEntity.ok("test!");
        }
    
        @GetMapping("/{id}")
        public ResponseEntity get(@PathVariable Long id) {
            return ResponseEntity.ok(repository.findById(id));
        }
    
        @PostMapping
        public ResponseEntity post(@RequestBody Board board) {
            return ResponseEntity.ok(repository.save(board));
        }
    
        @PutMapping("/{id}")
        public ResponseEntity put(@PathVariable Long id, @RequestBody Board board) {
            return ResponseEntity.ok(repository.save(board));
        }
    
        @DeleteMapping("/{id}")
        public ResponseEntity delete(@PathVariable Long id) {
            repository.deleteById(id);
    
            return ResponseEntity.noContent().build();
        }
    
    }
    ```

<br/>
<br/>

#### Start with SpringInitializr
1) Spring intializr(https://start.spring.io) 웹 사이트에서 아래와 같이 설정된 프로젝트 다운로드
    
    | Ttitle  | Value |
    |------|---|
    | `Project`  | Gradle Project |
    | `Language` | Java | 
    | `Spring Boot` | 2.2.4 | 
    | `Dependencies` | Spring Web, Spring Data JPA, Lombok, H2 Database | 

<br/>

* ref. 이후 과정은 [Start with Gradle Project](#start-with-gradle-project)의 3, 4, 5 참고