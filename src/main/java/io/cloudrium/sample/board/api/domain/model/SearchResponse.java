package io.cloudrium.sample.board.api.domain.model;

import io.cloudrium.sample.board.api.infrastructure.data.Board;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SearchResponse {

    public SearchResponse(List<Board> data, long totalCount) {
        this.totalCount = totalCount;

        if(data != null) {
            this.data = new ArrayList<>();

            data.forEach(d -> {
                this.data.add(new BoardResponse(d));
            });
        }
    }

    private List<BoardResponse> data;

    private long totalCount;

}
