package io.cloudrium.sample.board.api.repository;

import io.cloudrium.sample.board.api.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, BoardQueryDslRepository {
}
