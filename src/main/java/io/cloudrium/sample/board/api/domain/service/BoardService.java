package io.cloudrium.sample.board.api.domain.service;

import io.cloudrium.sample.board.api.domain.model.BoardRequest;
import io.cloudrium.sample.board.api.domain.model.BoardResponse;
import io.cloudrium.sample.board.api.domain.model.SearchRequest;
import io.cloudrium.sample.board.api.domain.model.SearchResponse;

public interface BoardService {

    SearchResponse search(SearchRequest request);

    BoardResponse get(Long id);

    void remove(Long id);

    BoardResponse add(BoardRequest board);

    BoardResponse change(BoardRequest board);

}
