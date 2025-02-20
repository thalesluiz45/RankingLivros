package br.edu.ifpb.RankingLivros.controllers;

import br.edu.ifpb.RankingLivros.entities.Author;
import br.edu.ifpb.RankingLivros.dtos.AuthorResponseDTO;
import br.edu.ifpb.RankingLivros.interfaces.SearchStrategy;
import br.edu.ifpb.RankingLivros.strategies.SearchByNameStrategy;
import br.edu.ifpb.RankingLivros.strategies.SearchByIdStrategy;
import br.edu.ifpb.RankingLivros.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public List<AuthorResponseDTO> getAuthors(
            @RequestParam(required = false) String query,
            @RequestParam(required = false) String type
    ) {
        if (query != null && type != null) {
            if ("name".equals(type)) {
                return searchByNameStrategy.search(query).stream()
                        .map(dto -> (AuthorResponseDTO) dto)
                        .collect(Collectors.toList());
            } else if ("id".equals(type)) {
                return searchByIdStrategy.search(query).stream()
                        .map(dto -> (AuthorResponseDTO) dto)
                        .collect(Collectors.toList());
            } else {
                throw new IllegalArgumentException("Tipo de busca inválido.");
            }
        } else {
            return authorRepository.findAll(PageRequest.of(0,20)).stream()
                    .map(AuthorResponseDTO::new)
                    .collect(Collectors.toList());
        }
    }
}