package io.cloudrium.sample.board.api.repository;

import io.cloudrium.sample.board.api.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
