package com.example.ProjetoLeilao.repositories;


import com.example.ProjetoLeilao.entities.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompradorRepository extends JpaRepository<Comprador, Integer> {
    List<Comprador> findByAtivo (Boolean ativo);
    List<Comprador> findByNome (String Nome);
}
