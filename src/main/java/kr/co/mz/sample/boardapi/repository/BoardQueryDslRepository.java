package kr.co.mz.sample.boardapi.repository;

import kr.co.mz.sample.boardapi.domain.Board;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardQueryDslRepository {

    List<Board> findPaginationBySearch(Pageable pageable, String q);

}
