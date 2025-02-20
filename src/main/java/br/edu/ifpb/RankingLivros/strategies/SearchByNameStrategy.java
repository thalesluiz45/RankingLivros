package br.edu.ifpb.RankingLivros.strategies;

import br.edu.ifpb.RankingLivros.dtos.AuthorResponseDTO;
import br.edu.ifpb.RankingLivros.dtos.BookResponseDTO;
import br.edu.ifpb.RankingLivros.dtos.GenreResponseDTO;
import br.edu.ifpb.RankingLivros.dtos.PublisherResponseDTO;
import br.edu.ifpb.RankingLivros.interfaces.ResponseDTO;
import br.edu.ifpb.RankingLivros.interfaces.SearchStrategy;
import br.edu.ifpb.RankingLivros.repositories.AuthorRepository;
import br.edu.ifpb.RankingLivros.repositories.BookRepository;
import br.edu.ifpb.RankingLivros.repositories.GenreRepository;
import br.edu.ifpb.RankingLivros.repositories.PublisherRepository;
import br.edu.ifpb.RankingLivros.interfaces.SearchableRepository;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByNameStrategy<T> implements SearchStrategy<T> {
    private final SearchableRepository<T, Long> repository;

    public SearchByNameStrategy(SearchableRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Override
    public List<ResponseDTO> search(String query) {
        if (repository instanceof AuthorRepository) {
            AuthorRepository authorRepository = (AuthorRepository) repository;
            return authorRepository.findByName(query).stream()
                    .map(author -> new AuthorResponseDTO(author))
                    .collect(Collectors.toList());
        } else if (repository instanceof BookRepository) {
            BookRepository bookRepository = (BookRepository) repository;
            return bookRepository.findByTitle(query).stream()
                    .map(book -> new BookResponseDTO(book))
                    .collect(Collectors.toList());
        } else if (repository instanceof GenreRepository) {
            GenreRepository genreRepository = (GenreRepository) repository;
            return genreRepository.findByName(query).stream()
                    .map(genre -> new GenreResponseDTO(genre))
                    .collect(Collectors.toList());
        } else if (repository instanceof PublisherRepository) {
            PublisherRepository publisherRepository = (PublisherRepository) repository;
            return publisherRepository.findByName(query).stream()
                    .map(publisher -> new PublisherResponseDTO(publisher))
                    .collect(Collectors.toList());
        } else {
            throw new UnsupportedOperationException("Tipo de repositório não suportado.");
        }
    }
}