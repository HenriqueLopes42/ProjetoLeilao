package com.example.ProjetoLeilao.ControllersTests;


import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.controllers.RacaController;
import com.example.ProjetoLeilao.entities.Raca;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
