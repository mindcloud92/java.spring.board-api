package kr.co.mz.sample.boardapi.repository;

import kr.co.mz.sample.boardapi.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, BoardQueryDslRepository {
}
