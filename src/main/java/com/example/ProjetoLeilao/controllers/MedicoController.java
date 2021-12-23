package com.example.ProjetoLeilao.controllers;

import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.entities.Medico;
import com.example.ProjetoLeilao.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Medico")
public class MedicoController {

   @Autowired
    private MedicoRepository medicoRepository;

   @GetMapping()
    public List<Medico> listar() {
        List<Medico> lista = medicoRepository.findByAtivo(true);
        return lista;
    }

    @GetMapping("/{id}")
    public Mensagem buscar(@PathVariable int id) {
       Medico medico = medicoRepository.findById(id).get();
       Mensagem msg = new Mensagem();
       msg.setMensagem("Registro encontrado");
       return msg;
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


}
