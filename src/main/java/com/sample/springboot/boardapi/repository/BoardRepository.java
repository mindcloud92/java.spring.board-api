package com.sample.springboot.boardapi.repository;

import com.sample.springboot.boardapi.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, BoardQueryDslRepository {
}
