package br.edu.ifpb.RankingLivros.repositories;

import br.edu.ifpb.RankingLivros.entities.Genre;
import br.edu.ifpb.RankingLivros.interfaces.SearchableRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends SearchableRepository<Genre, Long> {
    List<Genre> findByName(String name); // Busca por nome
}