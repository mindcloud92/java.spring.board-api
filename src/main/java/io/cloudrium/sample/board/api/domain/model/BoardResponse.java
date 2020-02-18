package io.cloudrium.sample.board.api.domain.model;

import io.cloudrium.sample.board.api.infrastructure.data.Board;
import io.cloudrium.sample.board.api.infrastructure.data.Comment;
import lombok.Getter;

import java.util.Collection;
import java.util.Date;

@Getter
public class BoardResponse {

    public BoardResponse(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.contents = board.getContents();
        this.createdAt = board.getCreatedAt();
    }

    public BoardResponse(Long id, String title, String contents, Date createdAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.createdAt = createdAt;
    }

    private Long id;

    private String title;

    private String contents;

    private Date createdAt;

    // ToDO: converting
    private Collection<Comment> comments;

}
