package io.cloudrium.sample.board.api.service;

import io.cloudrium.sample.board.api.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {

    List<Board> search();

    Board get(Long id);

    Board change(Long id, Board board);

    Board add(Board board);

    void remove(Long id);

}
