package com.example.ProjetoLeilao.RepositoriesTests;

import com.example.ProjetoLeilao.controllers.RacaController;
import com.example.ProjetoLeilao.entities.Comprador;
import com.example.ProjetoLeilao.entities.Raca;
import com.example.ProjetoLeilao.repositories.RacaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RacaRepositoryTests {

    @Autowired
    private RacaRepository racaRepository;

    @Autowired
    private RacaController racaController;

    @Test
    public void findByAtivoTest(){
        Boolean expected = true;
        Boolean result = false;

        try{
            List<Raca> lista = racaRepository.findByAtivo(true);
            System.out.println("Teste FindByAtivo");
            result = true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void findByIdRacaTest() {
        Boolean expected = true;
        Boolean result = false;

        try{
            List<Raca> lista = racaRepository.findByIdRaca(14);
            System.out.println("Teste FindByIdRaca");
            result = true;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void findByNomeTest() {
        Boolean expected = true;
        Boolean result = false;

        try {
            Raca raca = this.racaController.buscar(16);
            List<Raca> racaByName = racaRepository.findByNome(raca.getNome());
            result = (raca.getNome().equals(racaByName.get(0).getNome())) ? true : false;
        } catch (Exception ex){
            System.out.println("Erro: " + ex);
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }
}
