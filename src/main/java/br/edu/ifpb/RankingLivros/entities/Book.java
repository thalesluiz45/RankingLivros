package br.edu.ifpb.RankingLivros.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;

    private String isbn;
    private String isbn13;
    private String title;
    private String language_code;
    private Double average_rating;

    @ManyToOne
    @JoinColumn(name = "publisher_id", foreignKey = @ForeignKey(name = "book_publisher_fk"))
    private Publisher publisher;

    @ManyToMany
    @JoinTable(
            name = "book_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;

    @ManyToMany
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;
}