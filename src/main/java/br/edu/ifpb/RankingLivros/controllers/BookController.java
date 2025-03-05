package br.edu.ifpb.RankingLivros.controllers;

import br.edu.ifpb.RankingLivros.dtos.BookResponseDTO;
import br.edu.ifpb.RankingLivros.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<BookResponseDTO> getAll(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "20") int size) {
        return service.getAll(page, size);
    }

    @GetMapping("/{id}")
    public BookResponseDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
