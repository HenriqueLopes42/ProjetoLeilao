package com.example.ProjetoLeilao.ControllersTests;


import com.example.ProjetoLeilao.controllers.VendedorController;
import com.example.ProjetoLeilao.entities.Vendedor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VendedorControllerTests {

    @Autowired
    private VendedorController vendedorController;

    @Test
    public void listarTest() {

        Boolean expected = true;
        Boolean result = false;

        try {
            List<Vendedor> lista = vendedorController.listar();
            System.out.println("Teste de listar Vendedores:");
            result = true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }
}
