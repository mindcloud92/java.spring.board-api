package io.cloudrium.sample.board.api.domain.service.impl;

import io.cloudrium.sample.board.api.domain.service.BoardService;
import io.cloudrium.sample.board.api.infrastructure.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;

    public BoardServiceImpl(BoardRepository repository) {
        this.repository = repository;
    }
    
}
