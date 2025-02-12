package br.edu.ifpb.RankingLivros.interfaces;

import br.edu.ifpb.RankingLivros.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByName(String name);
}

