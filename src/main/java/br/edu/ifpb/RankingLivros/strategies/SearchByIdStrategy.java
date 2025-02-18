package br.edu.ifpb.RankingLivros.strategies;

import br.edu.ifpb.RankingLivros.dtos.AuthorResponseDTO;
import br.edu.ifpb.RankingLivros.dtos.BookResponseDTO;
import br.edu.ifpb.RankingLivros.dtos.GenreResponseDTO;
import br.edu.ifpb.RankingLivros.dtos.PublisherResponseDTO;
import br.edu.ifpb.RankingLivros.interfaces.ResponseDTO;
import br.edu.ifpb.RankingLivros.entities.Author;
import br.edu.ifpb.RankingLivros.entities.Book;
import br.edu.ifpb.RankingLivros.entities.Genre;
import br.edu.ifpb.RankingLivros.entities.Publisher;
import br.edu.ifpb.RankingLivros.interfaces.SearchStrategy;
import br.edu.ifpb.RankingLivros.interfaces.SearchableRepository;
import br.edu.ifpb.RankingLivros.exceptions.NotFoundException;

import javax.naming.Name;
import java.util.List;

public class SearchByIdStrategy<T> implements SearchStrategy<T> {
    private final SearchableRepository<T, Long> repository;

    public SearchByIdStrategy(SearchableRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Override
    public List<ResponseDTO> search(String query) {
        Long id = Long.parseLong(query);
        T entity = repository.findById(id).orElseThrow(NotFoundException::new);

        if (entity instanceof Author) {
            return List.of(new AuthorResponseDTO((Author) entity));
        } else if (entity instanceof Book) {
            return List.of(new BookResponseDTO((Book) entity));
        } else if (entity instanceof Genre) {
            return List.of(new GenreResponseDTO((Genre) entity));
        } else if (entity instanceof Publisher) {
            return List.of(new PublisherResponseDTO((Publisher) entity));
        } else {
            throw new IllegalArgumentException("Tipo de entidade não suportado: " + entity.getClass().getSimpleName());
        }
    }
}