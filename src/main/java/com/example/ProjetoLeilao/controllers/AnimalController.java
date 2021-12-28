package com.example.ProjetoLeilao.controllers;

import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.business.AnimalBiz;
import com.example.ProjetoLeilao.entities.Animal;
import com.example.ProjetoLeilao.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("animal")
@CrossOrigin
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private CompradorRepository compradorRepository;
    @Autowired
    private LeilaoRepository leilaoRepository;
    @Autowired
    private VendedorRepository vendedorRepository;
    @Autowired
    private RacaRepository racaRepository;

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


        AnimalBiz animalBiz = new AnimalBiz(animal,
                                animalRepository,
                                medicoRepository,
                                compradorRepository,
                                leilaoRepository,
                                vendedorRepository,
                                racaRepository);


        if (animalBiz.isValid()) {
            animal.setIdAnimal(0);
            animalRepository.save(animal);
            animalRepository.flush();
            msg.setMensagem("Animal incluido com sucesso");
        } else {
            msg.setErros(animalBiz.getErros());
            msg.setMensagem("Erro ao incluir animal: ");
        }


        return msg;

    }

    @PutMapping()
    public Mensagem alterar(@RequestBody Animal animal){
        Mensagem msg = new Mensagem();


        AnimalBiz animalBiz = new AnimalBiz(animal,animalRepository, medicoRepository, compradorRepository, leilaoRepository, vendedorRepository,racaRepository);


        if (animalBiz.isValid()) {
            animalRepository.save(animal);
            animalRepository.flush();
            msg.setMensagem("Animal alterado com sucesso");
        } else {
            msg.setErros(animalBiz.getErros());
            msg.setMensagem("Erro ao alterar animal: ");
        }


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
