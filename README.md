# #3. Paging & Sorting

1. add `PageRequest` to mapped controller method to search api

    ```java
    // BoardController.java
    
    package io.cloudrium.sample.board.api.controller;
    
    @RestController
    @RequestMapping("/boards")
    public class BoardController {    
        
        private final BoardRepository repository;
    
        public BoardController(BoardRepository repository) {
            this.repository = repository;
        }
    
        @GetMapping
        public ResponseEntity search(final Pageable request) {
            return ResponseEntity.ok(repository.findAll(request));
        }
    
    }
    ``` 

2. add service package & interface
    ```java
    // BoardService.java
    
    package io.cloudrium.sample.board.api.domain.service;
    
    public interface BoardService {
    
        Page<Board> search(Pageable request);
    
        Board get(Long id);
    
        Board change(Long id, Board board);
    
        Board add(Board board);
    
        void remove(Long id);
    
    }
    ```

3. add service implementation package & class
    ㄴ
