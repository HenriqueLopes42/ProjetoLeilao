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
}
