package com.example.ProjetoLeilao.controllers;


import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.entities.Leilao;
import com.example.ProjetoLeilao.repositories.LeilaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("leilao")
public class LeilaoController {

    @Autowired
    private LeilaoRepository leilaoRepository;

    @GetMapping
    public List<Leilao> listar (){
        List<Leilao> lista = leilaoRepository.findByAtivo(true);
        return lista;
    }

    @GetMapping("/{id}")
    public Leilao buscar(@PathVariable int id){
        Leilao leilao = leilaoRepository.findById(id).get();
        return leilao;
    }

    @PostMapping
    public Mensagem incluir (@RequestBody Leilao leilao){
        leilao.setIdLeilao(0);
        leilaoRepository.save(leilao);
        leilaoRepository.flush();

        Mensagem msg = new Mensagem();
        msg.setMensagem("Leilão inserido com sucesso");
        return msg;
    }

    @PutMapping
    public Leilao alterar (@RequestBody Leilao leilao){
        leilaoRepository.save(leilao);
        leilaoRepository.flush();
        return leilao;
    }

    @DeleteMapping
    public Leilao deletar(@RequestBody Leilao leilao){
        Leilao excluir = leilaoRepository.findById(leilao.getIdLeilao()).get();
        excluir.setAtivo(false);
        leilaoRepository.save(excluir);
        leilaoRepository.flush();
        return excluir;
    }

    @DeleteMapping("{id}")
    public Leilao deletar (@PathVariable Integer id){
        Leilao excluir = leilaoRepository.findById(id).get();
        excluir.setAtivo(false);
        leilaoRepository.save(excluir);
        leilaoRepository.flush();
        return excluir;
    }







}
