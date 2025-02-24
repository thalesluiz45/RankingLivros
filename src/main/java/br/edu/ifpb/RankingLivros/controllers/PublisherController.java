package br.edu.ifpb.RankingLivros.controllers;

import br.edu.ifpb.RankingLivros.dtos.PublisherResponseDTO;
import br.edu.ifpb.RankingLivros.entities.Publisher;
import br.edu.ifpb.RankingLivros.interfaces.ResponseDTO;
import br.edu.ifpb.RankingLivros.interfaces.SearchStrategy;
import br.edu.ifpb.RankingLivros.strategies.SearchByNameStrategy;
import br.edu.ifpb.RankingLivros.strategies.SearchByIdStrategy;
import br.edu.ifpb.RankingLivros.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherRepository repository;

    private final SearchStrategy<Publisher> searchByNameStrategy;
    private final SearchStrategy<Publisher> searchByIdStrategy;


    public PublisherController(PublisherRepository publisherRepository) {
        this.repository = repository;
        this.searchByNameStrategy = new SearchByNameStrategy<>(publisherRepository);
        this.searchByIdStrategy = new SearchByIdStrategy<>(publisherRepository);
    }

    @GetMapping
    public List<ResponseDTO> getControllers(
            @RequestParam(required = false) String query,
            @RequestParam(required = false) String type
    ) {
        if (query != null && type != null) {
            if ("name".equals(type)) {
                return searchByNameStrategy.search(query).stream()
                        .map(dto -> (PublisherResponseDTO) dto)
                        .collect(Collectors.toList());
            } else if ("id".equals(type)) {
                return searchByIdStrategy.search(query).stream()
                        .map(dto -> (PublisherResponseDTO) dto)
                        .collect(Collectors.toList());
            } else {
                throw new IllegalArgumentException("Tipo de busca inválido.");
            }
        } else {
            return repository.findAll(PageRequest.of(0,20)).stream()
                    .map(PublisherResponseDTO::new)
                    .collect(Collectors.toList());
        }
    }
}