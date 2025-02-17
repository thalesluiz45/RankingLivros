package br.edu.ifpb.RankingLivros.dtos;

import br.edu.ifpb.RankingLivros.entities.Genre;

public record GenreResponseDTO(
         Long genre_id,
         String name
) {
    public GenreResponseDTO(Genre genre) {
        this(
                genre.getGenre_id(),
                genre.getName()
        );
    }
}
