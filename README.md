# #3. Paging & Sorting

1. add `PageRequest` to mapped controller method to search api

```java
// BoardController.java

package io.cloudrium.sample.board.api.controller;

// imports dependencies...

@RestController
@RequestMapping("/boards")
public class BoardController {    

    @GetMapping
    public ResponseEntity search(final Pageable request) {
        return ResponseEntity.ok(repository.findAll(request));
    }

}
``` 

