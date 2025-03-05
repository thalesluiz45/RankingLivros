package br.edu.ifpb.RankingLivros.services;

import br.edu.ifpb.RankingLivros.dtos.BookResponseDTO;
import br.edu.ifpb.RankingLivros.entities.Book;
import br.edu.ifpb.RankingLivros.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService extends GenericService<Book, BookResponseDTO> {
    public BookService(BookRepository repository) {
        super(repository, BookResponseDTO::new);
    }
}
