package com.example.ProjetoLeilao.ControllersTests;


import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.controllers.MedicoController;
import com.example.ProjetoLeilao.entities.Medico;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MedicoControllerTests {

        @Autowired
        private MedicoController medicoController;

        @Test
        public void listarTest(){

            Boolean expected = true;
            Boolean result = false;

            try {
                List<Medico>lista = medicoController.listar();
                System.out.println("Teste de Listar Medicos ");
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

                int qtdAnterior = this.medicoController.listar().size();

                Medico medico = new Medico();
                medico.setNome("Rodolfo Ferreirako" + (qtdAnterior +100000));
                medico.setIdMedico(3);
                medico.setAtivo(true);
                medico.setEmail("rodolfo@fer.com");
                medico.setTelefone("67981354778");
                medico.setCrmv(6873);
                medico.setDataNascimento(new Date());
                Mensagem msg = this.medicoController.incluir(medico);

                int qtdNova = this.medicoController.listar().size();

                if (qtdNova == qtdAnterior + 1){

                    result = true;

                }else {
                    System.out.println("Medico não inserido: "+ msg.getMensagem());
                        for (String s: msg.getErros()){
                             System.out.println(s);
                    }
                }

            }catch (Exception ex){
                System.out.println("Erro o incluir Medico: "+ ex.getMessage());
                result = false;
            }
            assertThat(result).isEqualTo(expected);

        }

        @Test
        public void buscarTest(){
            Boolean expected = true;
            Boolean result = false;

            try {
                Medico medico = medicoController.buscar(9);
            if (medico.getIdMedico() != null) {
                result = true;
            } else {
                result = false;
            System.out.println("Medico - BuscarTest: Medico não encontrado!");
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
                    int qtdAnterior = this.medicoController.listar().size();

                    Medico medico = this.medicoController.buscar(9);
                    medico.setNome("Medico alterado " +(qtdAnterior+10001));
                    medico.setIdMedico(9);
                    medico.setCrmv(12312);
                    medico.setAtivo(true);
                    Mensagem msg = this.medicoController.alterar(medico);

                    Medico medicoAlterado = this.medicoController.buscar(9);
                    if (medico.getNome().equals(medicoAlterado.getNome())) {
                        result = true;
                        System.out.println("Nome do Medico Foi Alterado com Sucesso :");
                    } else {
                        result = false;
                        System.out.println("medico - AlterarTest: o nome nao foi alterado");
                        System.out.println(medico.getNome());
                        System.out.println(medicoAlterado.getNome());

                        for(String erro: msg.getErros()){
                            System.out.println(erro);
                        }
                    }

                } catch (Exception ex){
                    result = false;
                    System.out.println("medico - AlterarTest: "+ ex.getMessage());
                }
                assertThat(result).isEqualTo(expected);
            }

        @Test
        public void deletarTest(){

              Boolean expected = true;
              Boolean result = false;

            try{
            Medico medico = this.medicoController.buscar(9);
            medico.setAtivo(true);
            this.medicoController.alterar(medico);

            Integer id = medico.getIdMedico();
            this.medicoController.deletar(id);

            medico = this.medicoController.buscar(9);

            if (medico.getAtivo() == false){
                result = true;
            } else {
                result = false;
                System.out.println("medico deletar: nao foi possivel deletar o medico" );
            }

            medico.setAtivo(true);
            this.medicoController.alterar(medico);

        } catch (Exception ex){
            result = false;
            System.out.println("medico deletar:" + ex.getMessage());

        }

        assertThat(result).isEqualTo(expected);
    }

        @Test
        public void deletarTestByMedico() {
            Boolean expected = true;
            Boolean result = false;

            try{
                Medico medico = this.medicoController.buscar(9);
                medico.setAtivo(true);
                this.medicoController.alterar(medico);

                Integer id = medico.getIdMedico();
                this.medicoController.deletar(id);

                medico = this.medicoController.buscar(9);

                if (medico.getAtivo() == false){
                    result = true;
                    System.out.println("Medico Excluido do banco de dados: ");
                } else {
                    result = false;
                    System.out.println("medico deletar: nao foi possivel deletar o medico" );
                }

                medico.setAtivo(true);
                this.medicoController.alterar(medico);

            } catch (Exception ex){
                result = false;
                System.out.println("medico deletar:" + ex.getMessage());

            }

            assertThat(result).isEqualTo(expected);
        }


}
