package com.example.ProjetoLeilao.ControllersTests;


import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.controllers.VendedorController;
import com.example.ProjetoLeilao.entities.Vendedor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VendedorControllerTests {

    @Autowired
    private VendedorController vendedorController;

    @Test
    public void listarTest() {

        Boolean expected = true;
        Boolean result = false;

        try {
            List<Vendedor> lista = vendedorController.listar();
            System.out.println("Teste de listar Vendedores:");
            result = true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void incluirTest() {

        Boolean expected = true;
        Boolean result = false;

        try {
            int quantidadeAnterior = this.vendedorController.listar().size();

            Vendedor vendedor = new Vendedor();
            vendedor.setIdVendedor(1);
            vendedor.setAtivo(true);
            vendedor.setCpf("73289773450");
            vendedor.setNome("Mateus Benaio da Cunha" + (quantidadeAnterior + 10000000));
            vendedor.setEmail("Mateus@gmail.com");
            vendedor.setTelefone("67945852365");
            vendedor.setDataNascimento(new Date());
            Mensagem msg = this.vendedorController.incluir(vendedor);
            int quantidadeNova = this.vendedorController.listar().size();
            if (quantidadeNova == quantidadeAnterior + 1) {
                result = true;
            } else {
                System.out.println("Não incluir vendedor: " + msg.getMensagem());
                for (String s : msg.getErros()) {
                    System.out.println(s);
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro ao incluir o vendedor: " + ex.getMessage());
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }
}
