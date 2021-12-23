package com.example.ProjetoLeilao.controllers;

import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.entities.Medico;
import com.example.ProjetoLeilao.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medico")
public class MedicoController {

   @Autowired
    private MedicoRepository medicoRepository;

   @GetMapping()
    public List<Medico> listar() {
        List<Medico> lista = medicoRepository.findByAtivo(true);
        return lista;
    }

    @GetMapping("/{id}")
    public Medico buscar(@PathVariable int id) {
       Medico medico = medicoRepository.findById(id).get();
       return medico;
    }

    @PostMapping
    public Mensagem incluir(@RequestBody Medico medico) {
       Mensagem msg = new Mensagem();
       medico.setIdMedico(0);
       medicoRepository.save(medico);
       medicoRepository.flush();
       msg.setMensagem("Registro inserido.");
       return msg;
    }

    @PostMapping
    public Mensagem alterar(@RequestBody Medico medico) {
       medicoRepository.save(medico);
       medicoRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Registro alterado.");
        return msg;
    }

    @DeleteMapping
    public Mensagem deletar(@RequestBody Medico medico) {
        Medico excluir = medicoRepository.findById(medico.getIdMedico()).get();
        excluir.setAtivo(false);
        Mensagem msg = new Mensagem();
        msg.setMensagem("Registro excluido.");
        return msg;
    }

    @DeleteMapping("{id}")
    public Mensagem deletar(@PathVariable Integer id) {
        Medico excluir = medicoRepository.findById(id).get();
        excluir.setAtivo(false);
        medicoRepository.saveAndFlush(excluir);
        medicoRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Registro excluido.");
        return msg;
    }


}
