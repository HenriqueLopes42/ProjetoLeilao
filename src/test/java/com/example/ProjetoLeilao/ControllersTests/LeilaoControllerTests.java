package com.example.ProjetoLeilao.ControllersTests;

import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.controllers.LeilaoController;
import com.example.ProjetoLeilao.entities.Leilao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LeilaoControllerTests {

    @Autowired
    private LeilaoController leilaoController;

    @Test
    public void listarTest() {
        Boolean expected = false;
        Boolean result = false;

        try {
            List<Leilao> lista = leilaoController.listar();
            System.out.println("Teste de listar leilao");
            result = true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            result = false;
        }
    }

    @Test
    public void incluirTest(){

        Boolean expected = false;
        Boolean result = false;

        try {
            int quantidadeAnterior = this.leilaoController.listar().size();

            Leilao leilao = new Leilao();
            leilao.setIdLeilao(0);
            leilao.setAtivo(true);
            leilao.setNome("André");
            leilao.setData(new Date());
            leilao.setDescricao("Descricao");
            int quantidadeNova = this.leilaoController.listar().size();
            Mensagem msg = this.leilaoController.incluir(leilao);
            if (quantidadeNova == quantidadeAnterior + 1) {
                result = true;
            } else {
                System.out.println("Nao incluiu leilão: " + msg.getMensagem());
                result = false;
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
}
