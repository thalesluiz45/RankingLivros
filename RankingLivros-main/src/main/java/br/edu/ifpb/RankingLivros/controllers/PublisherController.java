package br.edu.ifpb.RankingLivros.controllers;

import br.edu.ifpb.RankingLivros.dtos.PublisherResponseDTO;
import br.edu.ifpb.RankingLivros.entities.Publisher;
import br.edu.ifpb.RankingLivros.exceptions.NotFoundException;
import br.edu.ifpb.RankingLivros.interfaces.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("publisher")
public class PublisherController {

    @Autowired
    private PublisherRepository repository;

    //Listar todas as editoras
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/list")
    public List<PublisherResponseDTO> getAll() {
        Set<String> uniqueNames = new LinkedHashSet<>();
        List<PublisherResponseDTO> bookList = repository.findAll(PageRequest.of(0,20)).stream().filter(publisher -> uniqueNames.add(publisher.getName())).map(PublisherResponseDTO::new).toList();
        return bookList;
    }

    //Busca por ID
    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponseDTO> getById(@PathVariable Long id) {
        Publisher publisher = repository.findById(id).orElseThrow(NotFoundException::new);
        return ResponseEntity.ok(new PublisherResponseDTO(publisher));
    }

    //Busca por nome
    @GetMapping("/search")
    public List<PublisherResponseDTO> searchName(@RequestParam String query) {
        return repository.findByName(query)
                .stream()
                .map(PublisherResponseDTO::new)
                .collect(Collectors.toList());
    }
}