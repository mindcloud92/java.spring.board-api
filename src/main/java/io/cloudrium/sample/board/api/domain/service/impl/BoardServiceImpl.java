package io.cloudrium.sample.board.api.domain.service.impl;

import io.cloudrium.sample.board.api.domain.model.BoardRequest;
import io.cloudrium.sample.board.api.domain.model.BoardResponse;
import io.cloudrium.sample.board.api.domain.model.SearchRequest;
import io.cloudrium.sample.board.api.domain.model.SearchResponse;
import io.cloudrium.sample.board.api.domain.service.BoardService;
import io.cloudrium.sample.board.api.infrastructure.data.Board;
import io.cloudrium.sample.board.api.infrastructure.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;

    public BoardServiceImpl(BoardRepository repository) {
        this.repository = repository;
    }

    @Override
    public SearchResponse search(SearchRequest request) {
        long totalCount = repository.count();
        List<Board> data = totalCount > 0 ? repository.findPaginationBySearch(request.getPageable(), request.getQ()) : null;

        return new SearchResponse(data, totalCount);
    }

    @Override
    public BoardResponse get(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public BoardResponse add(BoardRequest board) {
        return null;
    }

    @Override
    public BoardResponse change(BoardRequest board) {
        return null;
    }
//
//    @Override
//    public List<Board> search(Search request)
//    {
//        long totalCount = repository.count();
//        List<Board> boards = totalCount > 0 ? repository.findPaginationBySearch(request.getPageable(), request.getQ()) : null;
//
//        return boards;
//    }
//
//    @Override
//    public Board get(Long id) {
//        return repository.findById(id).orElseGet(null);
//    }
//
//    @Override
//    public void remove(Long id) {
//        repository.deleteById(id);
//    }
//
//    @Override
//    public Board add(Board board) {
//        return repository.save(board);
//    }
//
//    @Override
//    public Board change(Long id, Board board) {
//        Board entity = repository.findById(id).orElseGet(null);
//        if(entity == null)
//            // ToDO: 404 exception handler (custom exception)
//            throw new NullPointerException();
//
//        // ToDO: entity merge request
//
//        return repository.save(board);
//    }
}
