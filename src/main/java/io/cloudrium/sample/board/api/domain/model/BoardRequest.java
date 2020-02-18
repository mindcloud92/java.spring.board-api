package io.cloudrium.sample.board.api.domain.model;

import io.cloudrium.sample.board.api.infrastructure.data.Comment;
import lombok.Data;

import java.util.Collection;
import java.util.Date;

@Data
public class BoardRequest {

    private Long id;

    private String title;

    private String contents;

    private Date createdAt;

    private Collection<Comment> comments;

}
