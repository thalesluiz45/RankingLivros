package br.edu.ifpb.RankingLivros.repositories;

import br.edu.ifpb.RankingLivros.entities.Author;
import br.edu.ifpb.RankingLivros.interfaces.SearchableRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends SearchableRepository<Author, Long> {
    List<Author> findByName(String name); // Busca por nome
}