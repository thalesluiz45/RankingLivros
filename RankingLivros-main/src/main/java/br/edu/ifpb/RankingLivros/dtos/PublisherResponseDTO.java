package br.edu.ifpb.RankingLivros.dtos;

import br.edu.ifpb.RankingLivros.entities.Publisher;

public record PublisherResponseDTO(
        Long publisher_id,
        String name
) {
    public PublisherResponseDTO(Publisher publisher) {
        this(
                publisher.getPublisher_id(),
                publisher.getName()
        );
    }
}
