package br.edu.ifpb.RankingLivros.services;

import br.edu.ifpb.RankingLivros.dtos.AuthorResponseDTO;
import br.edu.ifpb.RankingLivros.entities.Author;
import br.edu.ifpb.RankingLivros.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends GenericService<Author, AuthorResponseDTO> {
    public AuthorService(AuthorRepository repository) {
        super(repository, AuthorResponseDTO::new);
    }
}
