package com.example.ProjetoLeilao.controllers;

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

    /*
    @PostMapping()
    public Mensagem incluir(@RequestBody Animal animal){

        animal.setIdAnimal(0);
        animalRepository.save(animal);
        animalRepository.flush();


    }
*/

}
