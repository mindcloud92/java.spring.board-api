package io.cloudrium.sample.board.api.v1;

import io.cloudrium.sample.board.api.domain.model.SearchRequest;
import io.cloudrium.sample.board.api.domain.model.SearchResponse;
import io.cloudrium.sample.board.api.domain.service.BoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("boards")
public class BoardController {

    private final BoardService service;

    public BoardController(BoardService service) {
        this.service = service;
    }

    @GetMapping
    public SearchResponse search(@ModelAttribute SearchRequest request) {
        return service.search(request);
    }
//
//    @PostMapping
//    public Board post(@RequestBody Board request) {
//        return service.add(request);
//    }
//
//    @GetMapping("/{id}")
//    public Board get(@PathVariable Long id) {
//        return service.get(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        service.remove(id);
//    }
//
//    @PatchMapping("/{id}")
//    public Board patch(@PathVariable Long id, @RequestBody Board board) {
//        return service.change(id, board);
//    }

}
