package com.example.ProjetoLeilao.RepositoriesTests;

import com.example.ProjetoLeilao.controllers.LeilaoController;
import com.example.ProjetoLeilao.entities.Leilao;
import com.example.ProjetoLeilao.repositories.LeilaoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LeilaoRepositoryTests {

    @Autowired
    private LeilaoRepository leilaoRepository;

    @Autowired
    private LeilaoController leilaoController;

    @Test
    public void findByAtivoTest() {
        Boolean expected = true;
        Boolean result = false;

        try {
            List<Leilao> list = leilaoRepository.findByAtivo(true);
            result = true;

            // list.forEach(result = !list.get(index).getAtivo());

            for (int index = 0; index < list.size(); index += 1)
                if (!list.get(index).getAtivo()) result = false;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void findByNomeTest() {
        Boolean expected = true;
        Boolean result = true;

        try {
            Leilao nomeByBuscar = leilaoController.buscar(7);
            List<Leilao>  nomeByRepository = leilaoRepository.findByNome(nomeByBuscar.getNome());
            result = nomeByBuscar.getNome().equals(nomeByRepository.get(0).getNome()) ? true : false;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void findByIdLeilao() {
        Boolean expected = true;
        Boolean result = false;

    try {
        List<Leilao> idByBuscar = leilaoRepository.findByIdLeilao(7);
        result = (idByBuscar.get(0).getIdLeilao() == leilaoRepository.findByIdLeilao(7).get(0).getIdLeilao()) ? true : false;
    } catch(Exception ex) {
        System.out.println(ex.getMessage());
        result = false;
    }
        assertThat(result).isEqualTo(expected);
    }


}
