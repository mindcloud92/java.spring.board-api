package io.cloudrium.sample.board.api.infrastructure.repository;

import io.cloudrium.sample.board.api.infrastructure.data.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, BoardQueryDslRepository {
}
