package br.edu.ifpb.RankingLivros.dtos;

import br.edu.ifpb.RankingLivros.entities.Publisher;
import br.edu.ifpb.RankingLivros.interfaces.ResponseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

public record PublisherResponseDTO(
        Long publisher_id,
        String name
) implements ResponseDTO {
    public PublisherResponseDTO(Publisher publisher) {
        this(
                publisher.getPublisher_id(),
                publisher.getName());
    }

    @Override
    @JsonIgnore
    public Long getId() {
        return publisher_id;
    }

    @Override
    public String getName() {
        return name;
    }
}