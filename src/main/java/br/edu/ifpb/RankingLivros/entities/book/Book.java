package br.edu.ifpb.RankingLivros.entities.book;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Table(name = "books")
@Entity(name = "books")
public class Book implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookID; // bookID
    private String title; // title
    private String authors; // authors
    private Double average_rating; // average_rating
    private String isbn; // isbn
    private String isbn13; // isbn13
    private String language_code; // language_code
    private Integer num_pages; // num_pages
    private Integer ratings_count; // ratings_count
    private Integer text_reviews_count; // text_reviews_count
    private String publication_date; // publication_date
    private String publisher; // publisher
}
