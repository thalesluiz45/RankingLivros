package br.edu.ifpb.RankingLivros.controllers;

import br.edu.ifpb.RankingLivros.entities.Genre;
import br.edu.ifpb.RankingLivros.interfaces.ResponseDTO;
import br.edu.ifpb.RankingLivros.interfaces.SearchStrategy;
import br.edu.ifpb.RankingLivros.strategies.SearchByNameStrategy;
import br.edu.ifpb.RankingLivros.strategies.SearchByIdStrategy;
import br.edu.ifpb.RankingLivros.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    private final SearchStrategy<Genre> searchByNameStrategy;
    private final SearchStrategy<Genre> searchByIdStrategy;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
        this.searchByNameStrategy = new SearchByNameStrategy<>(genreRepository);
        this.searchByIdStrategy = new SearchByIdStrategy<>(genreRepository);
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