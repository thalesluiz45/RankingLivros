package br.edu.ifpb.RankingLivros.strategies;

import br.edu.ifpb.RankingLivros.dtos.BookResponseDTO;
import br.edu.ifpb.RankingLivros.interfaces.ResponseDTO;
import br.edu.ifpb.RankingLivros.interfaces.SearchStrategy;
import br.edu.ifpb.RankingLivros.interfaces.SearchableRepository;
import br.edu.ifpb.RankingLivros.repositories.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByTitleStrategy<T> implements SearchStrategy<T> {
    private final SearchableRepository<T, Long> repository;

    public SearchByTitleStrategy(SearchableRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Override
    public List<ResponseDTO> search(String query) {
        if (repository instanceof BookRepository) {
            BookRepository bookRepository = (BookRepository) repository;
            return bookRepository.findByTitle(query).stream()
                    .map(book -> new BookResponseDTO(book))
                    .collect(Collectors.toList());
        } else {
            throw new UnsupportedOperationException("Busca por título não suportada para este repositório.");
        }
    }
}