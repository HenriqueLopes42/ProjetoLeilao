package com.example.ProjetoLeilao.controllers;

import com.example.ProjetoLeilao.entities.Raca;
import com.example.ProjetoLeilao.repositories.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("raca")
public class RacaController {
    @Autowired
    private RacaRepository racaRepository;

    @GetMapping()
    public List<Raca> listar() {
        List<Raca> lista = racaRepository.findByAtivo(true);
        return lista;
    }

    @GetMapping("/{id}")
    public Raca buscar(@PathVariable int id){
        Raca raca = racaRepository.findById(id).get();
        return raca;
    }
}
