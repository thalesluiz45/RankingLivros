package br.edu.ifpb.RankingLivros.controllers;

import br.edu.ifpb.RankingLivros.dtos.BookResponseDTO;
import br.edu.ifpb.RankingLivros.entities.Author;
import br.edu.ifpb.RankingLivros.exceptions.NotFoundException;
import br.edu.ifpb.RankingLivros.interfaces.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import br.edu.ifpb.RankingLivros.dtos.AuthorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    // Listar todos os autores
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/list")
    public List<AuthorResponseDTO> getAll(){
        List<AuthorResponseDTO> authors = authorRepository.findAll().stream().map(AuthorResponseDTO::new).toList();
        return authors;
    }

    // Buscar autor por ID
    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> getAuthorById(@PathVariable Long id) {
        Author author = authorRepository.findById(id).orElseThrow(NotFoundException::new);
        return ResponseEntity.ok(new AuthorResponseDTO(author));
    }

}

