package io.cloudrium.sample.board.api.controller;

import io.cloudrium.sample.board.api.service.BoardService;
import io.cloudrium.sample.board.api.entity.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
