package br.edu.ifpb.RankingLivros.dtos;

import br.edu.ifpb.RankingLivros.entities.Author;

public record AuthorResponseDTO(
        Long ID, // bookID
        String name
) {
    public AuthorResponseDTO(Author author) {
        this(
                author.getAuthorID(),
                author.getName()
        );
    }
}
