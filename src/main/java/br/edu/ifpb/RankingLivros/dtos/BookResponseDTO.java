package br.edu.ifpb.RankingLivros.dtos;

import br.edu.ifpb.RankingLivros.entities.Book;

public record BookResponseDTO(
        Long ID, // bookID
        String title
       ) {
    public BookResponseDTO(Book book){
        this(
                book.getID(),
                book.getTitle()
        );
    }
}
