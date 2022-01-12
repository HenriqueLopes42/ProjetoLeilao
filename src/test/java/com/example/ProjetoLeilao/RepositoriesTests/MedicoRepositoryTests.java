package com.example.ProjetoLeilao.RepositoriesTests;



import com.example.ProjetoLeilao.controllers.MedicoController;
import com.example.ProjetoLeilao.entities.Medico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@SpringBootTest
public class MedicoRepositoryTests {

    @Autowired
    private MedicoController medicoController;

    @Test
    public void findByAtivoTest() {

        Boolean expected = true;
        Boolean result = false;


        try {
            Medico medico = new Medico();
            List<Medico> lista = medicoController.listar();
            System.out.println("Lista de Medicos Ativos");
            result = true;


        }catch(Exception ex){
            System.out.println("Lista nao encontrada: " + ex.getMessage());
            result = false;

        }

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void findByIdMedicoTest(){

    }


    @Test
    public void findByNomeTest() {



    }
}
