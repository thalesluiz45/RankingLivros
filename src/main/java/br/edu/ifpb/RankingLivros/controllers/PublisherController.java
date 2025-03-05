package br.edu.ifpb.RankingLivros.controllers;

import br.edu.ifpb.RankingLivros.dtos.PublisherResponseDTO;
import br.edu.ifpb.RankingLivros.entities.Publisher;
import br.edu.ifpb.RankingLivros.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherRepository repository;

    //Listar todas as editoras
    @GetMapping
    @Transactional(readOnly = true)
    public List<PublisherResponseDTO> getAllPublishers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return repository.findAll(PageRequest.of(page, size)).stream()
                .map(PublisherResponseDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public PublisherResponseDTO getPublisherById(@PathVariable Long id) {
        Publisher publisher = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Editora não encontrada."));
        return new PublisherResponseDTO(publisher);
    }

}