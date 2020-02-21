# #2. Paging & Sorting

1. add `PageRequest` to search api

```java
// BoardController.java

package io.cloudrium.sample.board.api.controller;

// imports dependencies...

@RestController
@RequestMapping("/boards")
public class BoardController {

    @GetMapping
    public ResponseEntity search(@RequestParam(required = false) PageRequest request) {
        return ResponseEntity.ok(repository.findAll());
    }
    
    // ...

}
``` 
