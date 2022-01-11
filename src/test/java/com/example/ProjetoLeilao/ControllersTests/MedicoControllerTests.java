package com.example.ProjetoLeilao.ControllersTests;


import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.controllers.MedicoController;
import com.example.ProjetoLeilao.entities.Medico;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

                medico.setNome("Rodolfo Ferreira" + (qtdAnterior+100000));
                medico.setIdMedico(1);
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



}
