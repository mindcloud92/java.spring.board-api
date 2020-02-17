package com.sample.springboot.boardapi.service.impl;

import com.sample.springboot.boardapi.domain.Board;
import com.sample.springboot.boardapi.repository.BoardRepository;
import com.sample.springboot.boardapi.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository repository;

    @Override
    public List<Board> search(Pageable pageable, String q)
    {
        return repository.findPaginationBySearch(pageable, q);
    }

    @Override
    public Board get(Long id) {
        return repository.findById(id).orElseGet(null);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Board add(Board board) {
        return repository.save(board);
    }

    @Override
    public Board change(Long id, Board board) {
        Board entity = repository.findById(id).orElseGet(null);
        if(entity == null)
            // ToDO: 404 exception handler (custom exception)
            throw new NullPointerException();

        // ToDO: entity merge request

        return repository.save(board);
    }
}
