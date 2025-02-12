package br.edu.ifpb.RankingLivros.interfaces;

import br.edu.ifpb.RankingLivros.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

