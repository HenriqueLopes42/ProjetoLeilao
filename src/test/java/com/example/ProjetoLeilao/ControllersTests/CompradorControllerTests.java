package com.example.ProjetoLeilao.ControllersTests;

import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.controllers.CompradorController;
import com.example.ProjetoLeilao.entities.Comprador;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CompradorControllerTests {

    @Autowired
    private CompradorController compradorController;

    @Test
    public void listarTest(){
        Boolean expected = true;
        Boolean result = false;

        try{
            List<Comprador> listaComprador = this.compradorController.listar();

            System.out.println("Teste do listar comprador: ");
            result = true;
        }catch (Exception exErro){
            System.out.println("Erro: " + exErro);
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void IncluirTest(){
        Boolean expected = true;
        Boolean result = false;

        try {
            Integer quantidadeCompradorAnterior = this.compradorController.listar().size();

            Comprador novoComprador = new Comprador();
            novoComprador.setIdComprador(0);
            novoComprador.setNome("Joaquim Ramos Airen " + quantidadeCompradorAnterior +10);
            novoComprador.setCpf("01234567892");
            novoComprador.setDataNascimento(new Date());
            novoComprador.setTelefone("67992814411");
            novoComprador.setEmail("lhenriquelopes42@gmail.com");
            novoComprador.setIdLeilao(3);
            novoComprador.setAtivo(true);

            Mensagem msg = this.compradorController.incluir(novoComprador);

            Integer quantidadeCompradorNovo = this.compradorController.listar().size();

            if(quantidadeCompradorNovo == quantidadeCompradorAnterior+1){
                result = true;
            }else{
                System.out.println("Não foi possivel incluir o Comprador: "+ msg.getMensagem());
                for( String sErros: msg.getErros()){
                    System.out.println(sErros);
                }
            }
        }catch (Exception exErro){
            System.out.println("Erro ao tentar incluir comprador: : " + exErro.getMessage());
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void buscarTest(){
        Boolean expected = true;
        Boolean result = false;

        try{
            Comprador comprador = this.compradorController.buscar(2);

            if(comprador.getIdComprador() != null){
                result = true;
            }else{
                result = false;
                System.out.println("Comprador - Buscar: Não encontrou o comprador informado.");
            }

        }catch(Exception exErro){
            result = false;
            System.out.println(exErro.getMessage());
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void alterarTest(){
        Boolean expected = true;
        Boolean result = false;

        try{
            Comprador comprador = this.compradorController.buscar(2);
            comprador.setNome("Novo nome comprador");

            Mensagem msg = this.compradorController.alterar(comprador);
            Comprador compradorAlterado = this.compradorController.buscar(2);

            if(comprador.getNome().equals(compradorAlterado.getNome())){
                result = true;
            }else {
                result = false;
                System.out.println("Comprador - Alterar: Não foi alterado");
                System.out.println("Antigo nome: " + comprador.getNome());
                System.out.println("Novo nome: " + compradorAlterado.getNome());

                for(String msgErro: msg.getErros()){
                    System.out.println(msgErro);
                }
            }

        }catch(Exception exErro){
            result = false;
            System.out.println(exErro.getMessage());
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void deletarTest(){
        Boolean expected = true;
        Boolean result = false;

        try{
            Comprador comprador = this.compradorController.buscar(2);

            comprador.setAtivo(true);
            this.compradorController.alterar(comprador);
            Integer id = comprador.getIdComprador();
            this.compradorController.deletar(id);
            Comprador compradorDeletado = this.compradorController.buscar(2);

            if(compradorDeletado.getAtivo() == false){
                result = true;
            }else {
                result = false;
                System.out.println("Comprador deletar: nao foi deletado." );
            }
        }catch(Exception exErro){
            result = false;
            System.out.println(exErro.getMessage());
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void deletarTestByComprador(){
        Boolean expected = true;
        Boolean result = false;

        try{
            Comprador comprador = this.compradorController.buscar(2);
            comprador.setAtivo(true);
            this.compradorController.alterar(comprador);
            this.compradorController.deletar(comprador);

            comprador = this.compradorController.buscar(2);

            if(comprador.getAtivo() == false){
                result = true;
            }else {
                result = false;
                System.out.println("Comprador deletar: nao foi deletado." );
            }
        }catch(Exception exErro){
            result = false;
            System.out.println(exErro.getMessage());
        }
        assertThat(result).isEqualTo(expected);
    }




}
