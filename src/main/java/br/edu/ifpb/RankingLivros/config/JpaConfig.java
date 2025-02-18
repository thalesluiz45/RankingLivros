package br.edu.ifpb.RankingLivros.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "br.edu.ifpb.RankingLivros.repositories")
public class JpaConfig {
}