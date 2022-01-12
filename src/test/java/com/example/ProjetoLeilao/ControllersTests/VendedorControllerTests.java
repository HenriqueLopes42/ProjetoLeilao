package com.example.ProjetoLeilao.ControllersTests;


import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.controllers.VendedorController;
import com.example.ProjetoLeilao.entities.Animal;
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

    @Test
    public void buscarTest() {

        Boolean expected = true;
        Boolean result = false;

        try {
            Vendedor vendedor = vendedorController.buscar(1);
            if (vendedor.getIdVendedor() != null) {
                result = true;
            } else {
                result = false;
                System.out.println("Vendedor - BuscarTest: Vendedor não encontrado");
            }
        } catch (Exception ex) {
            result = false;
            System.out.println(ex.getMessage());
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void alterarTest() {

        Boolean expected = true;
        Boolean result = false;

        try {
            Vendedor vendedor = this.vendedorController.buscar(1);
            vendedor.setNome("Vendedor alterado");
            vendedor.setEmail("Email alterado");
            vendedor.setCpf("CPF alterado");
            vendedor.setDataNascimento(new Date());
            vendedor.setTelefone("Telefone alterado");
            Mensagem msg = this.vendedorController.alterar(vendedor);

            Vendedor vendedorAlterado = this.vendedorController.buscar(1);
            if (vendedor.getNome().equals(vendedorAlterado.getNome())) {
                result = true;
            } else {
                result = false;
                System.out.println("Vendedor - AlterarTest: O nome não foi alterado");
                System.out.println(vendedor.getNome());
                System.out.println(vendedorAlterado.getNome());

                for (String erro : msg.getErros()) {
                    System.out.println(erro);
                }
            }
        } catch (Exception ex) {
            result = false;
            System.out.println("Vendedor -AlterarTest: " + ex.getMessage());
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void deletarTest() {

        Boolean expected = true;
        Boolean result = false;
        try {

            Vendedor vendedor = this.vendedorController.buscar(1);
            vendedor.setAtivo(true);
            this.vendedorController.alterar(vendedor);

            Integer id = vendedor.getIdVendedor();
            this.vendedorController.deletar(id);

            vendedor = this.vendedorController.buscar(2);

            if (vendedor.getAtivo() == false) {
                result = true;
            } else {
                result = false;
                System.out.println("Vendedor deletar: nao foi possivel deletar o vendedor");
            }
            vendedor.setAtivo(true);
            this.vendedorController.alterar(vendedor);
        } catch (Exception ex) {
            result = false;
            System.out.println("Vendedor deletar:" + ex.getMessage());
        }
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void deletarTestByVendedor(){
        Boolean expected = true;
        Boolean result = false;
        try{
            Vendedor vendedor = this.vendedorController.buscar(2);
            vendedor.setAtivo(true);
            this.vendedorController.alterar(vendedor);

            this.vendedorController.deletar(vendedor);

            vendedor = this.vendedorController.buscar(2);

            if (vendedor.getAtivo() == false){
                result = true;
            } else {
                result = false;
                System.out.println("Vendedor deletar: nao foi possivel deletar o vendedor" );
            }
            vendedor.setAtivo(true);
            this.vendedorController.alterar(vendedor);
        } catch (Exception ex){
            result = false;
            System.out.println("Vendedor deletar:" + ex.getMessage());
        }
        assertThat(result).isEqualTo(expected);
    }
}
