package com.example.ProjetoLeilao.BusinessTests;

import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.business.LeilaoBiz;
import com.example.ProjetoLeilao.controllers.LeilaoController;
import com.example.ProjetoLeilao.entities.Leilao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LeilaoBizTests {

    private LeilaoBiz leilaoBiz;

    @Autowired
    private LeilaoController leilaoController;

    @Test
    public void testIsValid() {
        Boolean expected = true;
        Boolean result = false;
        String msg;
        try {

            Leilao leilao = leilaoController.buscar(1); // Salva registro 1 no em leilao
            msg = leilaoController.incluir(leilao).getMensagem(); //Tenta incluir registro igual
            if (msg == "Leilao alterado.") {
                result = false;
            } else if (msg == "Erro ao incluir leilão"){
                result = true;
            }

        } catch (Exception ex) {
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }
}
