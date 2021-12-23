package com.example.ProjetoLeilao.repositories;

import com.example.ProjetoLeilao.entities.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

    List<Vendedor> findByAtivo(Boolean ativo);


}
