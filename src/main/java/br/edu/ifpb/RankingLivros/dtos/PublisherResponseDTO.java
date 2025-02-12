package br.edu.ifpb.RankingLivros.dtos;

import br.edu.ifpb.RankingLivros.entities.Publisher;

public record PublisherResponseDTO(
        Long ID, // bookID
        String name
) {
    public PublisherResponseDTO(Publisher publisher) {
        this(
                publisher.getID(),
                publisher.getName()
        );
    }
}
