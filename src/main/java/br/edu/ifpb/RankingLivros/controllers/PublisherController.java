package br.edu.ifpb.RankingLivros.controllers;

import br.edu.ifpb.RankingLivros.entities.Publisher;
import br.edu.ifpb.RankingLivros.interfaces.ResponseDTO;
import br.edu.ifpb.RankingLivros.interfaces.SearchStrategy;
import br.edu.ifpb.RankingLivros.strategies.SearchByNameStrategy;
import br.edu.ifpb.RankingLivros.strategies.SearchByIdStrategy;
import br.edu.ifpb.RankingLivros.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    private final SearchStrategy<Publisher> searchByNameStrategy;
    private final SearchStrategy<Publisher> searchByIdStrategy;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
        this.searchByNameStrategy = new SearchByNameStrategy<>(publisherRepository);
        this.searchByIdStrategy = new SearchByIdStrategy<>(publisherRepository);
    }

    @GetMapping("/search")
    public List<ResponseDTO> search(@RequestParam String query, @RequestParam String type) {
        if ("name".equals(type)) {
            return searchByNameStrategy.search(query);
        } else if ("id".equals(type)) {
            return searchByIdStrategy.search(query);
        }
        throw new IllegalArgumentException("Tipo de busca inválido.");
    }
}