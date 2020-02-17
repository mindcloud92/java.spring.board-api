package io.cloudrium.sample.board.api.controller;

import io.cloudrium.sample.board.api.service.BoardService;
import io.cloudrium.sample.board.api.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("boards")
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping
    public List<Board> search(@RequestParam(required = false) Pageable pageable, @RequestParam(required = false) String q) {
        return service.search(pageable, q);
    }

    @PostMapping
    public Board post(@RequestBody Board request) {
        return service.add(request);
    }

    @GetMapping("/{id}")
    public Board get(@PathVariable Long id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.remove(id);
    }

    @PatchMapping("/{id}")
    public Board patch(@PathVariable Long id, @RequestBody Board board) {
        return service.change(id, board);
    }

}
