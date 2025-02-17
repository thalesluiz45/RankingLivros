package br.edu.ifpb.RankingLivros.interfaces;

import br.edu.ifpb.RankingLivros.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    List<Genre> findByName(String name);
}

