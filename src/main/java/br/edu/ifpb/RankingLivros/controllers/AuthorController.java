package br.edu.ifpb.RankingLivros.controllers;

import br.edu.ifpb.RankingLivros.dtos.AuthorResponseDTO;
import br.edu.ifpb.RankingLivros.entities.Author;
import br.edu.ifpb.RankingLivros.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    //Listar todos os autores
    @GetMapping
    @Transactional(readOnly = true)
    public List<AuthorResponseDTO> getAllAuthors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return repository.findAll(PageRequest.of(page, size)).stream()
                .map(AuthorResponseDTO::new)
                .collect(Collectors.toList());
    }

    //Buscar autor por ID
    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public AuthorResponseDTO getAuthorById(@PathVariable Long id) {
        Author author = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado."));
        return new AuthorResponseDTO(author);
    }

}