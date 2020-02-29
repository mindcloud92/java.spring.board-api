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
   ```java
   // BoardServiceImpl.java
   
   package io.cloudrium.sample.board.api.domain.service.impl;

   @Service
   public class BoardServiceImpl implements BoardService {
   
       private final BoardRepository repository;
   
       public BoardServiceImpl(BoardRepository repository) {
           this.repository = repository;
       }
   
       @Override
       public Page<Board> search(Pageable pageable) {
           return repository.findAll(pageable);
       }
   
       @Override
       public Board get(Long id) {
           return repository.findById(id).orElseThrow(NullPointerException::new);
       }
   
       @Override
       public Board change(Long id, Board board) {
           repository.findById(id).orElseThrow(NullPointerException::new);
   
           return repository.save(board);
       }
   
       @Override
       public Board add(Board board) {
           return repository.save(board);
       }
   
       @Override
       public void remove(Long id) {
           repository.findById(id).orElseThrow(NullPointerException::new);
   
           repository.deleteById(id);
       }
   }
   ```

4. apply the implemented service to the controller
    ```java
    // BoardController.java
   
    package io.cloudrium.sample.board.api.controller;
    
    @RestController
    @RequestMapping("/boards")
    public class BoardController {
    
        private final BoardService service;
    
        public BoardController(BoardService service) {
            this.service = service;
        }
    
        @GetMapping
        public ResponseEntity search(final Pageable request) {
            return ResponseEntity.ok(service.search(request));
        }
    
        @GetMapping("/{id}")
        public ResponseEntity get(@PathVariable Long id) {
            return ResponseEntity.ok(service.get(id));
        }
    
        @PostMapping
        public ResponseEntity post(@RequestBody Board board) {
            return ResponseEntity.ok(service.add(board));
        }
    
        @PutMapping("/{id}")
        public ResponseEntity put(@PathVariable Long id, @RequestBody Board board) {
            return ResponseEntity.ok(service.change(id, board));
        }
    
        @DeleteMapping("/{id}")
        public ResponseEntity delete(@PathVariable Long id) {
            service.remove(id);
    
            return ResponseEntity.noContent().build();
        }
    
    }
    ```