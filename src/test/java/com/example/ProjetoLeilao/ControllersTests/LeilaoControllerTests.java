package com.example.ProjetoLeilao.ControllersTests;

import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.controllers.LeilaoController;
import com.example.ProjetoLeilao.entities.Leilao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
    public void buscarTest() {

        Boolean expected = true;
        Boolean result = false;

        try {
            Leilao leilao = leilaoController.buscar(1);
            if (leilao.getIdLeilao() != null) { // Trocar para ternário
                result = true;
            } else {
                result = false;
                System.out.println("Leilao - BuscarTest - Registro de Leilao nao encontrado");
            }

        } catch (Exception ex) {
            result = false;
            System.out.println("Erro ao buscar Leilao" + ex.getMessage());
        }
        assertThat(result).isEqualTo(expected);
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
            int quantidadeAnterior = this.leilaoController.listar().size();

            leilao = this.leilaoController.buscar(1);
            leilao.setNome("Leilao teste" + (quantidadeAnterior));
            leilao.setAtivo(true);

            Mensagem msg = this.leilaoController.incluir(leilao);
            int quantidadeNova = this.leilaoController.listar().size();
            
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
             Leilao leilao = this.leilaoController.buscar(8);
             leilao.setNome("Leilao teste" + (int)(Math.random() * 100));
             this.leilaoController.alterar(leilao);
             // Mensagem msg = this.leilaoController.alterar(leilao); -- Mensagem nao esta funcionando

            Leilao leilaoAlterado = this.leilaoController.buscar(8);
            if (leilao.getNome().equals(leilaoAlterado.getNome())) {
                result = true;
            } else {
                result = false;
                System.out.println("leilao - AlterarTest: o nome nao foi alterado.");
                System.out.println(leilao.getNome());
                System.out.println(leilaoAlterado.getNome());

                /*
                for (String erro : msg.getErros()) {
                    System.out.println(erro);
                }
                */
            }
        } catch ( Exception ex ) {
            System.out.println("Erro ao alterar o leilão: " + ex.getMessage());
            result = false;
        }
        assertThat(expected).isEqualTo(result);
        // Assertions.assertEquals();
    }

    @Test
    public void deletarTest() {

        Boolean expected = true;
        Boolean result = false;

        try {

            Leilao leilao = this.leilaoController.buscar(8);
            leilao.setAtivo(true);
            this.leilaoController.alterar(leilao); // Pode dar erro se ja estava ativo, mas vai seguir o baile

            Integer idRegistroaExcluir = leilao.getIdLeilao();
            this.leilaoController.deletar(idRegistroaExcluir);

            leilao = this.leilaoController.buscar(8);

            result = !leilao.getAtivo() ? true : false; // Copiar pro outro que pode ser ternário

            leilao.setAtivo(true);
            this.leilaoController.alterar(leilao);
        } catch (Exception ex) {
            result = false;
            System.out.println("Leilao deletar: " + ex.getMessage());
        }


        assertThat(result).isEqualTo(expected);

    }

    @Test
    public void deletarByObjectTest() {
        Boolean expected = true;
        Boolean result = false;

        try {

            Leilao leilao = this.leilaoController.buscar(8);
            leilao.setAtivo(true);
            this.leilaoController.alterar(leilao); // Pode dar erro se ja estava ativo, mas vai seguir o baile

            this.leilaoController.deletar(leilao);

            leilao = this.leilaoController.buscar(8);

            result = !leilao.getAtivo() ? true : false; // Copiar pro outro que pode ser ternário

            leilao.setAtivo(true);
            this.leilaoController.alterar(leilao);
        } catch (Exception ex) {
            result = false;
            System.out.println("Leilao deletar: " + ex.getMessage());
        }


        assertThat(result).isEqualTo(expected);
    }
}
