package br.edu.ifpb.RankingLivros.interfaces;

import br.edu.ifpb.RankingLivros.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    List<Publisher> findByName(String name);
}

