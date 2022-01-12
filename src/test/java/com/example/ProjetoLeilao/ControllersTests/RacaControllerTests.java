package com.example.ProjetoLeilao.ControllersTests;


import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.controllers.RacaController;
import com.example.ProjetoLeilao.entities.Animal;
import com.example.ProjetoLeilao.entities.Raca;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.AbstractPersistable_;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RacaControllerTests {

    @Autowired
    private RacaController racaController;

    @Test
    public void listarTest(){

        Boolean expected = true;
        Boolean result = false;

        try{
            List<Raca> lista = racaController.listar();
            System.out.println("Teste de Listar Raças: ");
            result = true;
        }catch (Exception ex){
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
            int quantidadeAnterior = this.racaController.listar().size();

            Raca raca = new Raca();
            raca.setIdRaca(0);
            raca.setAtivo(true);
            raca.setDescricao("O Red Angus é uma raça internacional de gado de corte caracterizada por uma cor de pelagem marrom-avermelhada.");
            raca.setNome("Red Angus");
            Mensagem msg = this.racaController.incluir(raca);
            int quantidadeNova = this.racaController.listar().size();
            if(quantidadeNova == quantidadeAnterior + 1){
                result = true;
            } else{
                System.out.println("Raça nova não foi incluida.");
                for(String s: msg.getErros()){
                    System.out.println(s);
                }
            }
        }catch ( Exception ex){
            System.out.println("Erro ao incluir raça: "+ ex.getMessage());
            result = false;
        }

    }

    @Test
    public void buscarTest(){

        Boolean expected = true;
        Boolean result = false;

        try {
            Raca raca = racaController.buscar(15);
            if (raca.getIdRaca() != null) {
                result = true;
            } else{
                result = false;
                System.out.println("Raça - BuscarTest: Raça não encontrada!");
            }
        } catch ( Exception ex) {
            result = false;
            System.out.println(ex.getMessage());
        }
        assertThat(result). isEqualTo(expected);
    }

    @Test
    public void alterarTest() {

        Boolean expected = true;
        Boolean result = false;

        try {
            Raca raca = this.racaController.buscar(14);
            raca.setNome("Nova Raça");
            Mensagem msg = this.racaController.alterar(raca);

            Raca racaAlterada = this.racaController.buscar(14);
            if (raca.getNome().equals(racaAlterada.getNome())) {
                result = true;
            } else {
                result = false;
                System.out.println("Raça - AlterarTest: o nome da raça nã foi alterado.");
                System.out.println(raca.getNome());
                System.out.println(racaAlterada.getNome());

                for(String erro: msg.getErros()){
                    System.out.println(erro);
                }
            }
        } catch (Exception ex){
            result = false;
            System.out.println("Raça - AlterarRaça: "+ex.getMessage());
        }
        assertThat(result). isEqualTo(expected);
    }

    @Test
    public void deletarTest() {

        Boolean expected = true;
        Boolean result = false;

        try {

            Raca raca = this.racaController.buscar(14);
            raca.setAtivo(true);
            this.racaController.alterar(raca);

            Integer id = raca.getIdRaca();
            this.racaController.deletar(id);

            raca = this.racaController.buscar(14);

            if(raca.getAtivo() == false){
                result = true;
            } else{
                result = false;
                System.out.println("Raça - DeletarRaça: Não foi possível deletar raça.");
            }

            raca.setAtivo(true);
            this.racaController.alterar(raca);

        } catch (Exception ex){
            result = false;
            System.out.println("Raça deletar: "+ex.getMessage());
        }

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void deletarByRacaTest(){
        Boolean expected = true;
        Boolean result = false;
        try{

            Raca raca = this.racaController.buscar(15);
            raca.setAtivo(true);
            this.racaController.alterar(raca);
            this.racaController.deletar(raca);

            raca = this.racaController.buscar(15);

            if (raca.getAtivo() == false){
                result = true;
            } else {
                result = false;
                System.out.println("Raça - DeletarRaça: Não foi possível deletar raça.");
            }

            raca.setAtivo(true);
            this.racaController.alterar(raca);

        } catch (Exception ex){
            result = false;
            System.out.println("Raça deletar: "+ex.getMessage());
        }

        assertThat(result).isEqualTo(expected);
    }

}
