package br.edu.ifpb.RankingLivros.dtos;

import br.edu.ifpb.RankingLivros.entities.Author;

public record AuthorResponseDTO(
        Long author_id,
        String name
) {
    public AuthorResponseDTO(Author author) {
        this(
                author.getAuthor_id(),
                author.getName()
        );
    }
}
