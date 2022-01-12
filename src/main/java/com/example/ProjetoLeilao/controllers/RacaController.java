package com.example.ProjetoLeilao.controllers;

import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.business.AnimalBiz;
import com.example.ProjetoLeilao.business.RacaBiz;
import com.example.ProjetoLeilao.entities.Animal;
import com.example.ProjetoLeilao.entities.Raca;
import com.example.ProjetoLeilao.repositories.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("raca")
@CrossOrigin
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

    @PostMapping
    public Mensagem incluir(@RequestBody Raca raca){
        RacaBiz racaBiz = new RacaBiz(raca, racaRepository);
        Mensagem msg = new Mensagem ();

        if (racaBiz.isValid()){
            raca.setIdRaca(0);
            racaRepository.save(raca);
            racaRepository.flush();
            msg.setMensagem("Raça inserida com sucesso.");
        } else{
            msg.setErros(racaBiz.getErros());
            msg.setMensagem("Erro ao incluir raca: ");
        }
        return msg;
    }

    @PutMapping()
    public Mensagem alterar(@RequestBody Raca raca){
        Mensagem msg = new Mensagem();


        RacaBiz racaBiz = new RacaBiz(raca,racaRepository);


        if (racaBiz.isValid()) {
            racaRepository.save(raca);
            racaRepository.flush();
            msg.setMensagem("Raça alterada com sucesso");
        } else {
            msg.setErros(racaBiz.getErros());
            msg.setMensagem("Erro ao alterar raça: ");
        }
        return msg;
    }

    @DeleteMapping
    public Raca deletar(@RequestBody Raca raca){
        Raca excluir = racaRepository.findById(raca.getIdRaca()).get();
        excluir.setAtivo(false);
        racaRepository.save(excluir);
        racaRepository.flush();
        return excluir;
    }

    @DeleteMapping("/{id}")
    public Mensagem deletar(@PathVariable Integer id){
        Mensagem msg = new Mensagem();
        Raca excluir = racaRepository.findById(id).get();
        excluir.setAtivo(false);
        racaRepository.save(excluir);
        racaRepository.flush();
        msg.setMensagem("Raça deletada com sucesso");
        return msg;
    }
}
