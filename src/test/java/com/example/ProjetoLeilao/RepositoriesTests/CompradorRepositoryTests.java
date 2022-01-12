package com.example.ProjetoLeilao.RepositoriesTests;


import com.example.ProjetoLeilao.controllers.CompradorController;
import com.example.ProjetoLeilao.entities.Comprador;
import com.example.ProjetoLeilao.repositories.CompradorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CompradorRepositoryTests {


    @Autowired
    public CompradorRepository compradorRepository;

    @Autowired
    private CompradorController compradorController;

    @Test
    public void findByAtivoTest(){
        Boolean expected = true;
        Boolean result = false;

        try{
            List<Comprador> lista = compradorRepository.findByAtivo(true);
            result = true;

        }catch (Exception exErro){
            System.out.println("Erro: " + exErro);
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void findByIdCompradorTest(){
        Boolean expected = true;
        Boolean result = false;

        try{
            List<Comprador> comprador = compradorRepository.findByIdComprador(2);
            result = true;

        }catch (Exception exErro){
            System.out.println("Erro: " + exErro);
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void findByNomeTest(){
        Boolean expected = true;
        Boolean result = false;

        try{
            Comprador comprador = this.compradorController.buscar(2);
            List<Comprador> compradorByName = compradorRepository.findByNome(comprador.getNome());


            result = (comprador.getNome().equals(compradorByName.get(0).getNome())) ? true : false;
//            if(comprador.getNome().equals(compradorByName.get(0).getNome())){
//                result = true;
//            }else{
//                result = false;
//            }


        }catch (Exception exErro){
            System.out.println("Erro: " + exErro);
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }
}
