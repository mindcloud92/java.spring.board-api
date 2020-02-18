package io.cloudrium.sample.board.api.domain.model;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@Data
public class SearchRequest {

    private int page = 1;

    private int size = 10;

    private String q;

    public Pageable getPageable() {
        return PageRequest.of(this.page, this.size);
    }

}
