package br.edu.ifpb.RankingLivros.services;

import br.edu.ifpb.RankingLivros.dtos.GenreResponseDTO;
import br.edu.ifpb.RankingLivros.entities.Genre;
import br.edu.ifpb.RankingLivros.repositories.GenreRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends GenericService<Genre, GenreResponseDTO> {
    public GenreService(GenreRepository repository) {
        super(repository, GenreResponseDTO::new);
    }
}
