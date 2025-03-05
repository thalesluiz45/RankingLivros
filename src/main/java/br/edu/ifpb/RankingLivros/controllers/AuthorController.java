package br.edu.ifpb.RankingLivros.controllers;

import br.edu.ifpb.RankingLivros.dtos.AuthorResponseDTO;
import br.edu.ifpb.RankingLivros.services.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping
    public List<AuthorResponseDTO> getAll(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "20") int size) {
        return service.getAll(page, size);
    }

    @GetMapping("/{id}")
    public AuthorResponseDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
