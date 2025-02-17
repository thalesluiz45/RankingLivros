package br.edu.ifpb.RankingLivros.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("Não foi possível encontrar o livro desejado.");
    }
}
