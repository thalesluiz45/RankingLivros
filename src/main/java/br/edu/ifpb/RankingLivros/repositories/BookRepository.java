package br.edu.ifpb.RankingLivros.repositories;

import br.edu.ifpb.RankingLivros.entities.Book;
import br.edu.ifpb.RankingLivros.interfaces.SearchableRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends SearchableRepository<Book, Long> {
    List<Book> findByTitle(String title); // Busca por título
}