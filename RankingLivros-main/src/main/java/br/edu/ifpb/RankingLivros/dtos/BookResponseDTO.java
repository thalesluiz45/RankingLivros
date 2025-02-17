package br.edu.ifpb.RankingLivros.dtos;

import br.edu.ifpb.RankingLivros.entities.Book;

public record BookResponseDTO(
         Long book_id,
         String isbn,
         String isbn13,
         String title,
         String language_code,
         String average_rating,

         String[] authors,

         String[] genres,

         String[] publisher
) {
    public BookResponseDTO(Book book) {
        this(
                book.getBook_id(),
                book.getIsbn(),
                book.getIsbn13(),
                book.getTitle(),
                book.getLanguage_code(),
                book.getAverage_rating(),
                book.getAuthors().stream().map(author -> author.toString()).toArray(String[]::new),
                book.getGenres().stream().map(genre -> genre.toString()).toArray(String[]::new),
                book.getPublishers().stream().map(publisher -> publisher.toString()).toArray(String[]::new)
        );
    }
}
