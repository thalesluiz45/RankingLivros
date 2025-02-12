package br.edu.ifpb.RankingLivros.dtos;

import br.edu.ifpb.RankingLivros.entities.Author;
import br.edu.ifpb.RankingLivros.entities.Book;

public record AuthorResponseDTO(
        Long ID, // bookID
        String title
) {
    public AuthorResponseDTO(Author author){
        this(
                author.getAuthorID(),
                author.getName()
        );
    }
}
