package io.cloudrium.sample.board.api.infrastructure.repository;

import io.cloudrium.sample.board.api.infrastructure.data.Board;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardQueryDslRepository {

    List<Board> findPaginationBySearch(Pageable pageable, String q);

}
