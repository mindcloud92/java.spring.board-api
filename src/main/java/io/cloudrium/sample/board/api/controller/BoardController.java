package io.cloudrium.sample.board.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok("test!");
    }

}
