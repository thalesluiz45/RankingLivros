package br.edu.ifpb.RankingLivros.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisher_id;

    private String name;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
    private Set<Book> books;
}