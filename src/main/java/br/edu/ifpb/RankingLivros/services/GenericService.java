package br.edu.ifpb.RankingLivros.services;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class GenericService<T, DTO> {

    private final JpaRepository<T, Long> repository;
    private final Function<T, DTO> dtoConverter;

    protected GenericService(JpaRepository<T, Long> repository, Function<T, DTO> dtoConverter) {
        this.repository = repository;
        this.dtoConverter = dtoConverter;
    }

    public List<DTO> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<T> resultPage = repository.findAll(pageable);

        return resultPage.getContent().stream()
                .map(dtoConverter)
                .collect(Collectors.toList());
    }

    public DTO getById(Long id) {
        T entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro não encontrado."));
        return dtoConverter.apply(entity);
    }
}
