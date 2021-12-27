package com.example.ProjetoLeilao.repositories;

import com.example.ProjetoLeilao.entities.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeilaoRepository  extends JpaRepository<Leilao, Integer> {
    List<Leilao> findByAtivo(Boolean ativo);

    List<Leilao> findByIdLeilao(Integer idLeilao);

    List<Leilao> findByNome(String nome);
}
