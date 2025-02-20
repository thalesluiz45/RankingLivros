package br.edu.ifpb.RankingLivros.dtos;

import br.edu.ifpb.RankingLivros.entities.Genre;
import br.edu.ifpb.RankingLivros.interfaces.ResponseDTO;

public record GenreResponseDTO(Long genre_id, String name) implements ResponseDTO {
    public GenreResponseDTO(Genre genre) {
        this(genre.getGenre_id(), genre.getName());
    }

    @Override
    public Long getId() {
        return genre_id;
    }

    @Override
    public String getName() {
        return name;
    }
}