package com.example.ProjetoLeilao.RepositoriesTests;



import com.example.ProjetoLeilao.controllers.MedicoController;
import com.example.ProjetoLeilao.entities.Comprador;
import com.example.ProjetoLeilao.entities.Medico;
import com.example.ProjetoLeilao.entities.Raca;
import com.example.ProjetoLeilao.repositories.MedicoRepository;
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

    @Autowired
    private MedicoRepository medicoRepository;

    @Test
    public void findByAtivoTest() {

        Boolean expected = true;
        Boolean result = false;


        try{
            List<Medico> lista = medicoRepository.findByAtivo(true);
            result = true;

        }catch (Exception exErro){
            System.out.println("Erro: " + exErro);
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void findByIdMedicoTest(){
        Boolean expected = true;
        Boolean result = false;

        try{
            List<Medico> medico = medicoRepository.findByIdMedico(4);
            System.out.println("Lista de Ids Medicos: ");
            result = true;

        }catch (Exception ex){
            System.out.println("Erro: " + ex);
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void findByNomeTest() {
        Boolean expected = true;
        Boolean result = false;

        try {
            Medico medico = this.medicoController.buscar(15);
            List<Medico> medicoByName = medicoRepository.findByNome(medico.getNome());
            result = medico.getNome().equals(medicoByName.get(0).getNome()) ? true : false;
            System.out.println(medico.getNome());
            System.out.println(medicoByName.get(0).getNome());
        } catch (Exception ex){
            System.out.println("Erro: " + ex);
            result = false;
        }
        assertThat(result).isEqualTo(expected);


    }
}
