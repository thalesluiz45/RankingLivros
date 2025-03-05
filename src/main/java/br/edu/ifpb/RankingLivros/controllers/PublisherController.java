package br.edu.ifpb.RankingLivros.controllers;

import br.edu.ifpb.RankingLivros.dtos.PublisherResponseDTO;
import br.edu.ifpb.RankingLivros.services.PublisherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService service;

    public PublisherController(PublisherService service) {
        this.service = service;
    }

    @GetMapping
    public List<PublisherResponseDTO> getAll(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "20") int size) {
        return service.getAll(page, size);
    }

    @GetMapping("/{id}")
    public PublisherResponseDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
