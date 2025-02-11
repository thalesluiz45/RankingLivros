package br.edu.ifpb.RankingLivros.dtos;

import br.edu.ifpb.RankingLivros.entities.book.Book;

public record BookResponseDTO(
        Long bookID, // bookID
        String title, // title
        String authors, // authors
        Double average_rating, // average_rating
        String isbn, // isbn
        String isbn13, // isbn13
        String language_code, // language_code
        Integer num_pages, // num_pages
        Integer ratings_count, // ratings_count
        Integer text_reviews_count, // text_reviews_count
        String publication_date, // publication_date
        String publisher) {
    public BookResponseDTO(Book book){
        this(
                book.getBookID(),
                book.getTitle(),
                book.getAuthors(),
                book.getAverage_rating(),
                book.getIsbn(),
                book.getIsbn13(),
                book.getLanguage_code(),
                book.getNum_pages(),
                book.getRatings_count(),
                book.getText_reviews_count(),
                book.getPublication_date(),
                book.getPublisher()
        );
    }
}
