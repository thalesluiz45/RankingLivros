package br.edu.ifpb.RankingLivros.controllers;

import br.edu.ifpb.RankingLivros.dtos.GenreResponseDTO;
import br.edu.ifpb.RankingLivros.entities.Genre;
import br.edu.ifpb.RankingLivros.exceptions.NotFoundException;
import br.edu.ifpb.RankingLivros.interfaces.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    // Listar todos os generos
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/list")
    public List<GenreResponseDTO> getAll() {
        Set<String> uniqueNames = new LinkedHashSet<>();
        List<GenreResponseDTO> genre = genreRepository.findAll(PageRequest.of(0,20)).stream().filter(genres -> uniqueNames.add(genres.getName())).map(GenreResponseDTO::new).toList();
        return genre;
    }

    // Buscar generos por ID
    @GetMapping("/{id}")
    public ResponseEntity<GenreResponseDTO> getGenreById(@PathVariable Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow(NotFoundException::new);
        return ResponseEntity.ok(new GenreResponseDTO(genre));
    }

    //Busca por nome
    @GetMapping("/search")
    public List<GenreResponseDTO> searchName(@RequestParam String query) {
        return genreRepository.findByName(query)
                .stream()
                .map(GenreResponseDTO::new)
                .collect(Collectors.toList());
    }
}

