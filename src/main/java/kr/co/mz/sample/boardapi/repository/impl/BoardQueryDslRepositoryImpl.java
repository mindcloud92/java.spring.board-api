package kr.co.mz.sample.boardapi.repository.impl;

import kr.co.mz.sample.boardapi.domain.Board;
import kr.co.mz.sample.boardapi.domain.QBoard;
import kr.co.mz.sample.boardapi.repository.BoardQueryDslRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardQueryDslRepositoryImpl extends QuerydslRepositorySupport implements BoardQueryDslRepository {

    public BoardQueryDslRepositoryImpl() {
        super(Board.class);
    }

    @Override
    public List<Board> findPaginationBySearch(Pageable pageable, String q) {
        final QBoard board = QBoard.board;

        return from(board)
                .where(board.title.contains(q))
                .orderBy(board.createdAt.desc())
                .fetch();
    }
}
