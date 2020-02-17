package io.cloudrium.sample.board.api.service;

import java.util.List;
import io.cloudrium.sample.board.api.domain.Board;
import org.springframework.data.domain.Pageable;

public interface BoardService {

    List<Board> search(Pageable pageable, String q);

    Board get(Long id);

    void remove(Long id);

    Board add(Board board);

    Board change(Long id, Board board);

}
