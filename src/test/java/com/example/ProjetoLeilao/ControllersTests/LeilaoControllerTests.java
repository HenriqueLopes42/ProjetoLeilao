package com.example.ProjetoLeilao.ControllersTests;

import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.controllers.LeilaoController;
import com.example.ProjetoLeilao.entities.Leilao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LeilaoControllerTests {

    @Autowired
    private LeilaoController leilaoController;

    @BeforeEach
    public void purposelessMethod() {

    }

    @Test
    public void listarTest() {
        Boolean expected = true;
        Boolean result = true;

        try {
            List<Leilao> list = leilaoController.listar();
            System.out.println("Teste de listar leilões");
            result = true;

        } catch (Exception ex) {
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
            Leilao leilao = new Leilao();
            leilao = this.leilaoController.buscar(1);
            leilao.setNome("Leilao de teste");
            leilao.setAtivo(true);

            int quantidadeAnterior = this.leilaoController.listar().size();

            Mensagem msg = this.leilaoController.incluir(leilao);
            int quantidadeNova = this.leilaoController.listar().size(); // não seria incluir?
            
            if (quantidadeNova == quantidadeAnterior + 1)
                result = true;
            else {
                System.out.println("Nao foi possível incluir o leilão: " + msg.getMensagem());
                result = false;
                for( String s: msg.getErros()){
                    System.out.println(s);
                }
            }
        } catch ( Exception ex ){
            System.out.println("Erro ao incluir o leilão: " + ex.getMessage());
            result = false;
        }

        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void alterarTest() {
        Boolean expected = true;
        Boolean result = false;

        try {
             // Mensagem msg = this.leilaoController.alterar(leilao);
             result = true;
        } catch ( Exception ex ) {
            System.out.println("Erro ao alterar o leilão: " + ex.getMessage());
            result = false;
        }
        // Assertions.assertEquals();
    }
}
