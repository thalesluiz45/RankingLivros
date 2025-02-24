package br.edu.ifpb.RankingLivros.controllers;

import br.edu.ifpb.RankingLivros.dtos.GenreResponseDTO;
import br.edu.ifpb.RankingLivros.entities.Genre;
import br.edu.ifpb.RankingLivros.interfaces.ResponseDTO;
import br.edu.ifpb.RankingLivros.interfaces.SearchStrategy;
import br.edu.ifpb.RankingLivros.strategies.SearchByNameStrategy;
import br.edu.ifpb.RankingLivros.strategies.SearchByIdStrategy;
import br.edu.ifpb.RankingLivros.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreRepository repository;

    private final SearchStrategy<Genre> searchByNameStrategy;
    private final SearchStrategy<Genre> searchByIdStrategy;

    public GenreController(GenreRepository genreRepository) {
        this.repository = genreRepository;
        this.searchByNameStrategy = new SearchByNameStrategy<>(genreRepository);
        this.searchByIdStrategy = new SearchByIdStrategy<>(genreRepository);
    }


    @GetMapping
    public List<ResponseDTO> getGenres(
            @RequestParam(required = false) String query,
            @RequestParam(required = false) String type
    ) {
        if (query != null && type != null) {
            if ("name".equals(type)) {
                return searchByNameStrategy.search(query).stream()
                        .map(dto -> (GenreResponseDTO) dto)
                        .collect(Collectors.toList());
            } else if ("id".equals(type)) {
                return searchByIdStrategy.search(query).stream()
                        .map(dto -> (GenreResponseDTO) dto)
                        .collect(Collectors.toList());
            } else {
                throw new IllegalArgumentException("Tipo de busca inválido.");
            }
        } else {
            return repository.findAll(PageRequest.of(0, 20)).stream()
                    .map(GenreResponseDTO::new)
                    .collect(Collectors.toList());
        }
    }
}