package br.edu.ifpb.RankingLivros.controllers;

import br.edu.ifpb.RankingLivros.entities.Author;
import br.edu.ifpb.RankingLivros.interfaces.ResponseDTO;
import br.edu.ifpb.RankingLivros.interfaces.SearchStrategy;
import br.edu.ifpb.RankingLivros.strategies.SearchByNameStrategy;
import br.edu.ifpb.RankingLivros.strategies.SearchByIdStrategy;
import br.edu.ifpb.RankingLivros.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    private final SearchStrategy<Author> searchByNameStrategy;
    private final SearchStrategy<Author> searchByIdStrategy;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        this.searchByNameStrategy = new SearchByNameStrategy<>(authorRepository);
        this.searchByIdStrategy = new SearchByIdStrategy<>(authorRepository);
    }

    @GetMapping("/search")
    public List<ResponseDTO> search(@RequestParam String query, @RequestParam String type) {
        if ("name".equals(type)) {
            return searchByNameStrategy.search(query);
        } else if ("id".equals(type)) {
            return searchByIdStrategy.search(query);
        }
        throw new IllegalArgumentException("Tipo de busca inválido.");
    }
}