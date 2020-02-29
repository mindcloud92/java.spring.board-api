package io.cloudrium.sample.board.api.domain.service.impl;

import io.cloudrium.sample.board.api.domain.service.BoardService;
import io.cloudrium.sample.board.api.infrastructure.data.Board;
import io.cloudrium.sample.board.api.infrastructure.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;

    public BoardServiceImpl(BoardRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Board> search(Pageable request) {
        return repository.findAll(request);
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
