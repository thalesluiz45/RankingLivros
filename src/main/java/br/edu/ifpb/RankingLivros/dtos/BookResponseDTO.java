package br.edu.ifpb.RankingLivros.dtos;

import br.edu.ifpb.RankingLivros.entities.Book;
import br.edu.ifpb.RankingLivros.interfaces.ResponseDTO;

public record BookResponseDTO(
        Long book_id,
        String isbn,
        String isbn13,
        String title,
        String language_code,
        String average_rating
) implements ResponseDTO {
    public BookResponseDTO(Book book) {
        this(
                book.getBook_id(),
                book.getIsbn(),
                book.getIsbn13(),
                book.getTitle(),
                book.getLanguage_code(),
                book.getAverage_rating()
        );
    }

    @Override
    public Long getId() {
        return book_id;
    }

    @Override
    public String getName() {
        return title;
    }
}