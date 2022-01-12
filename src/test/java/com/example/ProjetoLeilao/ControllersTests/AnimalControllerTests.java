package com.example.ProjetoLeilao.ControllersTests;

import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.controllers.AnimalController;
import com.example.ProjetoLeilao.entities.Animal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AnimalControllerTests {

    @Autowired
    private AnimalController animalController;

    @Test
    public void listarTest(){

        Boolean expected = true;
        Boolean result = false;

        try {
            List<Animal> lista = animalController.listar();
            System.out.println("Teste de Listar animais:" );
            result = true;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            result = false;
        }
        assertThat(result).isEqualTo(expected);

    }

    @Test
    public void incluirTest(){

        Boolean expected = true;
        Boolean result = false;

        try {
            int quantidadeAnterior = this.animalController.listar().size();

            Animal animal = new Animal();
            animal.setIdAnimal(0);
            animal.setAtivo(true);
            animal.setIdade(4);
            animal.setIdComprador(1);
            animal.setIdLeilao(1);
            animal.setIdMedico(4);
            animal.setIdRaca(14);
            animal.setIdVendedor(1);
            animal.setNome("Boi tatatuado" + (quantidadeAnterior +1000000));
            animal.setPesoArroba(150.0f);
            animal.setPreco(1200.0f);
            animal.setRegistro("448877");
            Mensagem msg = this.animalController.incluir(animal);
            int quantidadeNova = this.animalController.listar().size();
            if (quantidadeNova == quantidadeAnterior + 1) {
                result = true;
            } else {
                System.out.println("nao incluiu animal: "+ msg.getMensagem());
                for( String s: msg.getErros()){
                    System.out.println(s);
                }
            }
        } catch ( Exception ex){
            System.out.println("Erro ao incluir animal: " + ex.getMessage());
            result = false;
        }

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void buscarTest(){

        Boolean expected = true;
        Boolean result = false;

        try {
            Animal animal = animalController.buscar(1);
            if (animal.getIdAnimal() != null) {
                result = true;
            } else {
                result = false;
                System.out.println("Animal - BuscarTest: Animal não encontrado!");
            }
        }catch ( Exception ex){
            result = false;
            System.out.println(ex.getMessage());
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void alterarTest(){

        Boolean expected = true;
        Boolean result = false;

        try {
            Animal animal = this.animalController.buscar(2);
            animal.setNome("Animalzinho alterado");
            animal.setIdMedico(4);
            animal.setIdRaca(14);
            Mensagem msg = this.animalController.alterar(animal);

            Animal animalAlterado = this.animalController.buscar(2);
            if (animal.getNome().equals(animalAlterado.getNome())) {
                result = true;
            } else {
                result = false;
                System.out.println("animal - AlterarTest: o nome nao foi alterado");
                System.out.println(animal.getNome());
                System.out.println(animalAlterado.getNome());

                for(String erro: msg.getErros()){
                    System.out.println(erro);
                }
            }

        } catch (Exception ex){
            result = false;
            System.out.println("animal - AlterarTest: "+ex.getMessage());
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void deletarTest(){

        Boolean expected = true;
        Boolean result = false;
        try{

            Animal animal = this.animalController.buscar(2);
            animal.setAtivo(true);
            this.animalController.alterar(animal);

            Integer id = animal.getIdAnimal();
            this.animalController.deletar(id);

            animal = this.animalController.buscar(2);

            if (animal.getAtivo() == false){
                result = true;
            } else {
                result = false;
                System.out.println("Animal deletar: nao foi possivel deletar o animal" );
            }

            animal.setAtivo(true);
            this.animalController.alterar(animal);

        } catch (Exception ex){
            result = false;
            System.out.println("Animal deletar:" + ex.getMessage());

        }

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void deletarTestByAnimal(){
        Boolean expected = true;
        Boolean result = false;
        try{

            Animal animal = this.animalController.buscar(2);
            animal.setAtivo(true);
            this.animalController.alterar(animal);
            this.animalController.deletar(animal);

            animal = this.animalController.buscar(2);
            result = animal.getAtivo() ? false : true;
            animal.setAtivo(true);
            this.animalController.alterar(animal);

        } catch (Exception ex){
            result = false;
            System.out.println("Animal deletar:" + ex.getMessage());
        }

        assertThat(result).isEqualTo(expected);
    }



}
