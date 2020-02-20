package io.cloudrium.sample.board.api.infrastructure.repository;

import io.cloudrium.sample.board.api.infrastructure.data.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
