package br.edu.ifpb.RankingLivros.controllers;

import br.edu.ifpb.RankingLivros.dtos.GenreResponseDTO;
import br.edu.ifpb.RankingLivros.services.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService service;

    public GenreController(GenreService service) {
        this.service = service;
    }

    @GetMapping
    public List<GenreResponseDTO> getAll(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "20") int size) {
        return service.getAll(page, size);
    }

    @GetMapping("/{id}")
    public GenreResponseDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
