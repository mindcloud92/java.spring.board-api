package com.sample.springboot.boardapi.repository;

import com.sample.springboot.boardapi.domain.Board;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardQueryDslRepository {

    List<Board> findPaginationBySearch(Pageable pageable, String q);

}
