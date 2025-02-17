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

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }

    public String getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(String average_rating) {
        this.average_rating = average_rating;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    private String isbn;
    private String isbn13;
    private String title;
    private String language_code;
    private String average_rating;


    @ManyToMany(fetch = FetchType.EAGER)
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
