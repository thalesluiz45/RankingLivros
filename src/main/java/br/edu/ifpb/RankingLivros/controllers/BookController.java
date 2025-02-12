package br.edu.ifpb.RankingLivros.controllers;

import br.edu.ifpb.RankingLivros.dtos.BookResponseDTO;
import br.edu.ifpb.RankingLivros.entities.Book;
import br.edu.ifpb.RankingLivros.exceptions.NotFoundException;
import br.edu.ifpb.RankingLivros.interfaces.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookRepository repository;

    //Listar todos os livros
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/list")
    public List<BookResponseDTO> getAll() {
        List<BookResponseDTO> bookList = repository.findAll().stream().map(BookResponseDTO::new).toList();
        return bookList;
    }

    //Busca por ID
    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getById(@PathVariable Long id) {
        Book book = repository.findById(id).orElseThrow(NotFoundException::new);
        return ResponseEntity.ok(new BookResponseDTO(book));
    }

    //Busca por título
    @GetMapping("/search")
    public List<BookResponseDTO> searchBooks(@RequestParam String query) {
        return repository.findByTitle(query)
                .stream()
                .map(BookResponseDTO::new)
                .collect(Collectors.toList());
    }
}