package br.edu.ifpb.RankingLivros.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@Table(name = "books")
@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;

    private String isbn;
    private String isbn13;
    private String title;
    private String language_code;
    private String average_rating;

    @ManyToMany
    @JoinTable(
            name = "book_authors", // Nome da tabela de junção
            joinColumns = @JoinColumn(name = "book_id"), // Nome da coluna referindo a Book
            inverseJoinColumns = @JoinColumn(name = "author_id") // Nome da coluna referindo a Author
    )
    private Set<Author> authors;

    @ManyToMany
    @JoinTable(
            name = "book_publishers", // Nome da tabela de junção
            joinColumns = @JoinColumn(name = "book_id"), // Nome da coluna referindo a Book
            inverseJoinColumns = @JoinColumn(name = "publisher_id") // Nome da coluna referindo a Publisher
    )
    private Set<Publisher> publishers;

    @ManyToMany
    @JoinTable(
            name = "book_genre", // Nome da tabela de junção
            joinColumns = @JoinColumn(name = "book_id"), // Nome da coluna referindo a Book
            inverseJoinColumns = @JoinColumn(name = "genre_id") // Nome da coluna referindo a Genre
    )
    private Set<Genre> genres;
}
