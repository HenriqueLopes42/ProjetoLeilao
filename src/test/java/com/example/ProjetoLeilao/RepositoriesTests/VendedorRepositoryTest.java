package com.example.ProjetoLeilao.RepositoriesTests;

import com.example.ProjetoLeilao.controllers.VendedorController;
import com.example.ProjetoLeilao.entities.Raca;
import com.example.ProjetoLeilao.entities.Vendedor;
import com.example.ProjetoLeilao.repositories.VendedorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VendedorRepositoryTest {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private VendedorController vendedorController;

    @Test
    public void findByAtivoTest(){
        Boolean expected = true;
        Boolean result = false;

        try{
            List<Vendedor> lista = vendedorRepository.findByAtivo(true);
            System.out.println("Teste FindByAtivo");
            result = true;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void findByIdVendedorTest() {
        Boolean expected = true;
        Boolean result = false;

        try{
            List<Vendedor> lista = vendedorRepository.findByIdVendedor(2);
            System.out.println("Teste FindByIdVendedor");
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
            Vendedor vendedor = this.vendedorController.buscar(2);
            List<Vendedor> vendedorRepositoryByNome= vendedorRepository.findByNome(vendedor.getNome());
            result = (vendedor.getNome().equals(vendedorRepositoryByNome.get(0).getNome())) ? true : false;
        } catch (Exception ex){
            System.out.println("Erro: " + ex);
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }

}
