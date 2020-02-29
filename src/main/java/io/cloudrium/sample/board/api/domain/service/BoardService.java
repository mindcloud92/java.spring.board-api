package io.cloudrium.sample.board.api.domain.service;

import io.cloudrium.sample.board.api.infrastructure.data.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {

    Page<Board> search(Pageable request);

    Board get(Long id);

    Board change(Long id, Board board);

    Board add(Board board);

    void remove(Long id);

}
