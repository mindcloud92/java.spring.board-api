package io.cloudrium.sample.board.api.controller;

import io.cloudrium.sample.board.api.entity.Board;
import io.cloudrium.sample.board.api.service.BoardService;
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
    public ResponseEntity search() {
        return ResponseEntity.ok(service.search());
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
