package br.edu.ifpb.RankingLivros.repositories;

import br.edu.ifpb.RankingLivros.entities.Publisher;
import br.edu.ifpb.RankingLivros.interfaces.SearchableRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends SearchableRepository<Publisher, Long> {
}