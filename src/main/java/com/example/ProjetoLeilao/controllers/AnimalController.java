package com.example.ProjetoLeilao.controllers;

import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.entities.Animal;
import com.example.ProjetoLeilao.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("animal")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping()
    public List<Animal> listar(){
        List<Animal> lista = animalRepository.findByAtivo(true);
        return lista;
    }

    @GetMapping("{id}")
    public Animal buscar(@PathVariable Integer id){
        Animal animal = animalRepository.findById(id).get();
        return  animal;
    }


    @PostMapping()
    public Mensagem incluir(@RequestBody Animal animal){
        Mensagem msg = new Mensagem();


        animal.setIdAnimal(0);
        animalRepository.save(animal);
        animalRepository.flush();
        msg.setMensagem("Animal incluido com sucesso");

        return msg;

    }

    @PutMapping()
    public Mensagem alterar(@RequestBody Animal animal){
        Mensagem msg = new Mensagem();

        animalRepository.save(animal);
        animalRepository.flush();
        msg.setMensagem("Animal alterado com sucesso");

        return msg;

    }

    @DeleteMapping()
    public Mensagem deletar(@RequestBody Animal animal) {
        Mensagem msg = new Mensagem();

        Animal excluir = animalRepository.findById(animal.getIdAnimal()).get();
        excluir.setAtivo(false);
        animalRepository.save(excluir);
        animalRepository.flush();
        msg.setMensagem("Animal excluido com sucesso");

        return msg;
    }

    @DeleteMapping("{id}")
    public Mensagem deletar(@PathVariable Integer id) {
        Mensagem msg = new Mensagem();

        Animal excluir = animalRepository.findById(id).get();
        excluir.setAtivo(false);
        animalRepository.save(excluir);
        animalRepository.flush();
        msg.setMensagem("Animal excluido com sucesso");

        return msg;
    }


}
