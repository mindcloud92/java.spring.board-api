# #1. Rest api with spring boot

0. create gradle project
<br/>
0. modify build.gradle   
    - add spring boot plugin & spring boot starter web dependency
        ```gradle
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
        <br/> 
    - change group, version
        ```gradle
        group 'group'
        ```
   <br/>
    
0. src에 package 추가
<br/>
0. add application class & write code 
    - Optional) set up *resources/application.yml* server port 
<br/>    
0. add controller package & BoardController class  
    - write api<br/>
        ex> GET /boards
<br/>    
0. Run application 
    - call GET /boards api 
