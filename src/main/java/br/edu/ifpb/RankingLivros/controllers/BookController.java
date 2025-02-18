package br.edu.ifpb.RankingLivros.controllers;

import br.edu.ifpb.RankingLivros.entities.Book;
import br.edu.ifpb.RankingLivros.dtos.BookResponseDTO;
import br.edu.ifpb.RankingLivros.interfaces.SearchStrategy;
import br.edu.ifpb.RankingLivros.strategies.SearchByTitleStrategy;
import br.edu.ifpb.RankingLivros.strategies.SearchByIdStrategy;
import br.edu.ifpb.RankingLivros.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    private final SearchStrategy<Book> searchByTitleStrategy;
    private final SearchStrategy<Book> searchByIdStrategy;

    public BookController(BookRepository repository) {
        this.repository = repository;
        this.searchByTitleStrategy = new SearchByTitleStrategy<>(repository);
        this.searchByIdStrategy = new SearchByIdStrategy<>(repository);
    }

    // Endpoint para buscar livros por título, ID ou retornar todos os livros
    @GetMapping
    public List<BookResponseDTO> getBooks(
            @RequestParam(required = false) String query,
            @RequestParam(required = false) String type
    ) {
        if (query != null && type != null) {
            // Se os parâmetros query e type forem fornecidos, realiza a busca
            if ("title".equals(type)) {
                return searchByTitleStrategy.search(query).stream()
                        .map(dto -> (BookResponseDTO) dto)
                        .collect(Collectors.toList());
            } else if ("id".equals(type)) {
                return searchByIdStrategy.search(query).stream()
                        .map(dto -> (BookResponseDTO) dto)
                        .collect(Collectors.toList());
            } else {
                throw new IllegalArgumentException("Tipo de busca inválido.");
            }
        } else {
            // Se nenhum parâmetro for fornecido, retorna todos os livros
            return repository.findAll().stream()
                    .map(BookResponseDTO::new)
                    .collect(Collectors.toList());
        }
    }
}