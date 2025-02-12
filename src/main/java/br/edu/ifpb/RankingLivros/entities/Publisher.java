package br.edu.ifpb.RankingLivros.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@Table(name = "publishers")
@Entity(name = "publishers")
public class Publisher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String name;

    @ManyToMany(mappedBy = "publishers")
    private Set<Book> books;
}

