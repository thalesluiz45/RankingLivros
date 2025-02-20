package br.edu.ifpb.RankingLivros.interfaces;

import br.edu.ifpb.RankingLivros.interfaces.ResponseDTO;
import java.util.List;

public interface SearchStrategy<T> {
    List<ResponseDTO> search(String query);
}