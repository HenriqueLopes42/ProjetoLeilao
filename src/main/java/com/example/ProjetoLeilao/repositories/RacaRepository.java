package com.example.ProjetoLeilao.repositories;

import com.example.ProjetoLeilao.entities.Leilao;
import com.example.ProjetoLeilao.entities.Raca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Integer> {
    List<Raca> findByAtivo(Boolean ativo);
    List<Leilao> findByIdRaca(Integer idRaca);
    List<Raca> findByNome(String nome);

}
