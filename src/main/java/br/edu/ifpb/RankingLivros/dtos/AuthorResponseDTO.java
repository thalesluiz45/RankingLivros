package br.edu.ifpb.RankingLivros.dtos;

import br.edu.ifpb.RankingLivros.entities.Author;
import br.edu.ifpb.RankingLivros.interfaces.ResponseDTO;

public record AuthorResponseDTO(
        Long author_id,
        String name
) implements ResponseDTO {
    public AuthorResponseDTO(Author author) {
        this(
                author.getAuthor_id(),
                author.getName());
    }

    @Override
    public Long getId() {
        return author_id;
    }

    @Override
    public String getName() {
        return name;
    }
}