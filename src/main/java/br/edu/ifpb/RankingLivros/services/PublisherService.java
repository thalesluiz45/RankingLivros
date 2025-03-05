package br.edu.ifpb.RankingLivros.services;

import br.edu.ifpb.RankingLivros.dtos.PublisherResponseDTO;
import br.edu.ifpb.RankingLivros.entities.Publisher;
import br.edu.ifpb.RankingLivros.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherService extends GenericService<Publisher, PublisherResponseDTO> {
    public PublisherService(PublisherRepository repository) {
        super(repository, PublisherResponseDTO::new);
    }
}
