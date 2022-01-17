package com.example.ProjetoLeilao.controllers;

import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.business.LeilaoBiz;
import com.example.ProjetoLeilao.entities.Leilao;
import com.example.ProjetoLeilao.repositories.LeilaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("leilao")
@CrossOrigin
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
        LeilaoBiz leilaoBiz = new LeilaoBiz(leilao, leilaoRepository);
        Mensagem msg = new Mensagem();

        if(leilaoBiz.isValid()){
            leilao.setIdLeilao(0);
            leilaoRepository.save(leilao);
            leilaoRepository.flush();
            msg.setMensagem("Leilão Incluido com sucesso!");

        } else{
            msg.setErros(leilaoBiz.getErros());
            msg.setMensagem("Erro ao incluir leilão");
        }
        return msg;
    }

    @PutMapping
    public Mensagem alterar (@RequestBody Leilao leilao){
        Mensagem msg = new Mensagem();
        leilaoRepository.save(leilao);
        leilaoRepository.flush();
        msg.setMensagem("Leilao alterado.");
        return msg;
    }

    @DeleteMapping
    public Mensagem deletar(@RequestBody Leilao leilao){
        Leilao excluir = leilaoRepository.findById(leilao.getIdLeilao()).get();
        Mensagem msg = new Mensagem();
        excluir.setAtivo(false);
        leilaoRepository.save(excluir);
        leilaoRepository.flush();
        msg.setMensagem("Leilão excluido com sucesso");
        return msg;
    }

    @DeleteMapping("{id}")
    public Mensagem deletar (@PathVariable Integer id){
        Leilao excluir = leilaoRepository.findById(id).get();
        Mensagem msg = new Mensagem();
        excluir.setAtivo(false);
        leilaoRepository.save(excluir);
        leilaoRepository.flush();
        msg.setMensagem("Animal excluido com sucesso");
        return msg;
    }
}
