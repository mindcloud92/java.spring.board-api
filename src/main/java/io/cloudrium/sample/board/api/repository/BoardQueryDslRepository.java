package io.cloudrium.sample.board.api.repository;

import io.cloudrium.sample.board.api.domain.Board;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardQueryDslRepository {

    List<Board> findPaginationBySearch(Pageable pageable, String q);

}
