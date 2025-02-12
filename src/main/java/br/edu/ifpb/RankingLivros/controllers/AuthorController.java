package br.edu.ifpb.RankingLivros.controllers;

import br.edu.ifpb.RankingLivros.dtos.AuthorResponseDTO;
import br.edu.ifpb.RankingLivros.dtos.PublisherResponseDTO;
import br.edu.ifpb.RankingLivros.entities.Author;
import br.edu.ifpb.RankingLivros.exceptions.NotFoundException;
import br.edu.ifpb.RankingLivros.interfaces.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    // Listar todos os autores
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/list")
    public List<AuthorResponseDTO> getAll() {
        Set<String> uniqueNames = new LinkedHashSet<>();
        List<AuthorResponseDTO> authors = authorRepository.findAll().stream().filter(author -> uniqueNames.add(author.getName())).map(AuthorResponseDTO::new).toList();
        return authors;
    }

    // Buscar autor por ID
    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> getAuthorById(@PathVariable Long id) {
        Author author = authorRepository.findById(id).orElseThrow(NotFoundException::new);
        return ResponseEntity.ok(new AuthorResponseDTO(author));
    }

    //Busca por nome
    @GetMapping("/search")
    public List<AuthorResponseDTO> searchName(@RequestParam String query) {
        return authorRepository.findByName(query)
                .stream()
                .map(AuthorResponseDTO::new)
                .collect(Collectors.toList());
    }
}

