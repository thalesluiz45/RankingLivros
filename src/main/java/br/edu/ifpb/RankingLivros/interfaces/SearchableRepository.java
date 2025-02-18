package br.edu.ifpb.RankingLivros.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchableRepository<T, ID> extends JpaRepository<T, ID> {
    // Métodos comuns a todos os repositórios podem ser definidos aqui
}