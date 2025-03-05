package br.edu.ifpb.RankingLivros.controllers;

import br.edu.ifpb.RankingLivros.dtos.GenreResponseDTO;
import br.edu.ifpb.RankingLivros.entities.Genre;
import br.edu.ifpb.RankingLivros.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreRepository repository;

    //Listar todos os gêneros
    @GetMapping
    @Transactional(readOnly = true)
    public List<GenreResponseDTO> getAllGenres(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return repository.findAll(PageRequest.of(page, size)).stream()
                .map(GenreResponseDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public GenreResponseDTO getGenreById(@PathVariable Long id) {
        Genre genre = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Gênero não encontrado."));
        return new GenreResponseDTO(genre);
    }

}