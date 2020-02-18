package io.cloudrium.sample.board.api.infrastructure.data;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Data
@Entity
public class Board  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private Date createdAt = new Date();

    @JoinColumn
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Comment> comments;

}
