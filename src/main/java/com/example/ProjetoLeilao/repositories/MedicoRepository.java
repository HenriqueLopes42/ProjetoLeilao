package com.example.ProjetoLeilao.repositories;

import com.example.ProjetoLeilao.entities.Medico;
import com.example.ProjetoLeilao.entities.Raca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    List<Medico> findByAtivo(Boolean ativo);
    List<Medico> findByIdMedico(Integer idMedico);
}
