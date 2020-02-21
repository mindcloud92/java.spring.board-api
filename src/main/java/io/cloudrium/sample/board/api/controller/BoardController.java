package io.cloudrium.sample.board.api.controller;

import io.cloudrium.sample.board.api.infrastructure.data.Board;
import io.cloudrium.sample.board.api.infrastructure.repository.BoardRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardRepository repository;

    public BoardController(BoardRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity search(@RequestParam(required = false) PageRequest request) {
        return ResponseEntity.ok(repository.findAll());
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
