package com.example.ProjetoLeilao.controllers;

import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.entities.Comprador;
import com.example.ProjetoLeilao.entities.Medico;
import com.example.ProjetoLeilao.repositories.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("Comprador")

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
    public Mensagem buscar(@PathVariable int id) {
        Comprador comprador = compradorRepository.findById(id).get();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Registro encontrado");
        return msg;
    }

    @PostMapping
    public Mensagem incluir(@RequestBody Comprador comprador) {
        Mensagem msg = new Mensagem();
        comprador.setIdComprador(0);
        compradorRepository.save(comprador);
        compradorRepository.flush();
        msg.setMensagem("Registro inserido.");
        return msg;
    }

    @PostMapping
    public Mensagem alterar(@RequestBody Comprador comprador) {
        compradorRepository.save(comprador);
        compradorRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Registro alterado.");
        return msg;
    }

    @DeleteMapping
    public Mensagem deletar(@RequestBody Comprador comprador) {
        Comprador excluir = compradorRepository.findById(comprador.getIdComprador()).get();
        excluir.setAtivo(false);
        Mensagem msg = new Mensagem();
        msg.setMensagem("Registro excluido.");
        return msg;
    }

    @DeleteMapping("{id}")
    public Mensagem deletar(@PathVariable Integer id) {
        Comprador excluir = compradorRepository.findById(id).get();
        excluir.setAtivo(false);
        compradorRepository.saveAndFlush(excluir);
        compradorRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Registro excluido.");
        return msg;
    }



}
