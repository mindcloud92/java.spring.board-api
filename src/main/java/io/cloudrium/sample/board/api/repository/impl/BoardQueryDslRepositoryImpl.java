package io.cloudrium.sample.board.api.repository.impl;

import io.cloudrium.sample.board.api.repository.BoardQueryDslRepository;
import io.cloudrium.sample.board.api.domain.Board;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import io.cloudrium.sample.board.api.domain.QBoard;

@Repository
public class BoardQueryDslRepositoryImpl extends QuerydslRepositorySupport implements
        BoardQueryDslRepository {

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
