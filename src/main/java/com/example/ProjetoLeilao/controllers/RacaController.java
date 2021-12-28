package com.example.ProjetoLeilao.controllers;

import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.business.RacaBiz;
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

    @PutMapping
    public Raca alterar (@RequestBody Raca raca){
        racaRepository.save(raca);
        racaRepository.flush();
        return raca;
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
    public Raca deletar(@PathVariable Integer id){
        Raca excluir = racaRepository.findById(id).get();
        excluir.setAtivo(false);
        racaRepository.save(excluir);
        racaRepository.flush();
        return excluir;
    }
}
