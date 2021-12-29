package com.example.ProjetoLeilao.controllers;

import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.business.CompradorBiz;
import com.example.ProjetoLeilao.entities.Comprador;
import com.example.ProjetoLeilao.repositories.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("comprador")
@CrossOrigin




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

    @PostMapping
    public Mensagem incluir(@RequestBody Comprador comprador) {
        CompradorBiz compradorBiz = new CompradorBiz(comprador, compradorRepository);

        Mensagem msg = new Mensagem();
        if(compradorBiz.isValid()) {
            comprador.setIdComprador(0);
            comprador.setAtivo(true);
            compradorRepository.save(comprador);
            compradorRepository.flush();
            msg.setMensagem("Registro inserido.");
        } else {
            msg.setErros(compradorBiz.getErros());
            msg.setMensagem("Erro ao incluir Comprador: ");
        }

        comprador.setIdComprador(0);
        comprador.setAtivo(true);
        compradorRepository.save(comprador);
        compradorRepository.flush();
        msg.setMensagem("Registro inserido.");
        return msg;
    }

    @PutMapping
    public Mensagem alterar(@RequestBody Comprador comprador) {
        CompradorBiz compradorBiz = new CompradorBiz(comprador, compradorRepository);
        Mensagem msg = new Mensagem();

        if(compradorBiz.isValid()) {
            comprador.setIdComprador(0);
            comprador.setAtivo(true);
            compradorRepository.save(comprador);
            compradorRepository.flush();
            msg.setMensagem("Registro Alterado.");
        } else {
            msg.setErros(compradorBiz.getErros());
            msg.setMensagem("Erro ao Alterar Comprador: ");
        }
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
        compradorRepository.save(excluir);
        compradorRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Registro excluido.");
        return msg;
    }



}
