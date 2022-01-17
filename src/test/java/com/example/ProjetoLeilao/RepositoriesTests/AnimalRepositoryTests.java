package com.example.ProjetoLeilao.RepositoriesTests;


import com.example.ProjetoLeilao.controllers.AnimalController;
import com.example.ProjetoLeilao.entities.Animal;
import com.example.ProjetoLeilao.repositories.AnimalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AnimalRepositoryTests {

    @Autowired
    public AnimalRepository animalRepository;

    @Autowired
    public AnimalController animalController;

    @Test
    public void findByAtivoTest(){
        Boolean expected = true;
        Boolean result = false;

        try{
            List<Animal> lista = animalRepository.findByAtivo(true);
            result = true;
        }catch (Exception exErro){
            System.out.println("Erro: " + exErro);
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void findByNomeTest(){
        Boolean expected = true;
        Boolean result = false;

        try{
            Animal animal = this.animalController.buscar(3);
            List<Animal> animalByName = animalRepository.findByNome(animal.getNome());

            result = (animal.getNome().equals(animalByName.get(0).getNome())) ? true: false;
        } catch (Exception ex){
            System.out.println("Erro: " + ex);
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }
}
