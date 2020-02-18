package io.cloudrium.sample.board.api.infrastructure.repository.impl;

import io.cloudrium.sample.board.api.infrastructure.data.QBoard;
import io.cloudrium.sample.board.api.infrastructure.repository.BoardQueryDslRepository;
import io.cloudrium.sample.board.api.infrastructure.data.Board;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

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
                // ToDO: improvement target
                .offset(pageable.getPageNumber() * (pageable.getPageSize() - 1))
                .limit(pageable.getPageSize())
                .fetch();
    }
}
