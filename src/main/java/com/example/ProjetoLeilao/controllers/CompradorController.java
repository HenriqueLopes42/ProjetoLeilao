package com.example.ProjetoLeilao.controllers;

import com.example.ProjetoLeilao.entities.Comprador;
import com.example.ProjetoLeilao.entities.Medico;
import com.example.ProjetoLeilao.repositories.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("comprador")

public class CompradorController {

    @Autowired
    public CompradorRepository compradorRepository;

    //Incusão da lista
    @GetMapping()
    public List<Comprador> listar () {

        List<Comprador> lista = compradorRepository.findByAtivo(true);
        return lista;
    }

    @GetMapping("/{id}")
    public Comprador buscar (@PathVariable int id ){

        Comprador busca = compradorRepository.findById(id).get();
        return busca;

    }


}
