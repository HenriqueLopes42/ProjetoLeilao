package com.example.ProjetoLeilao.BusinessTests;

import com.example.ProjetoLeilao.business.CompradorBiz;
import com.example.ProjetoLeilao.entities.Comprador;
import com.example.ProjetoLeilao.repositories.CompradorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CompradorBizTests {

    @Autowired
    public CompradorRepository compradorRepository;

    @Test
    public void isValidTest(){
        Boolean expected = true;
        Boolean result = false;
        try{
            Comprador comprador = new Comprador();
            comprador.setIdComprador(0);
            comprador.setNome("Joaquim do teste");
            comprador.setCpf("01234567892");
            comprador.setDataNascimento(new Date());
            comprador.setTelefone("67992814411");
            comprador.setEmail("lhenriquelopes42@gmail.com");
            comprador.setIdLeilao(3);
            comprador.setAtivo(true);

            CompradorBiz compradorBiz = new CompradorBiz(comprador, compradorRepository);
            Boolean bizIsValid = compradorBiz.isValid();

            result = bizIsValid || !bizIsValid;


        }catch (Exception ex){
            System.out.println(ex.getMessage());
            result = false;
        }

        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void isValidByCompradorTest(){
        Boolean expected = true;
        Boolean result = false;
        try{
            Comprador comprador = new Comprador();
            comprador.setIdComprador(0);
            comprador.setNome("Joaquim do teste");
            comprador.setCpf("01234567892");
            comprador.setDataNascimento(new Date());
            comprador.setTelefone("67992814411");
            comprador.setEmail("lhenriquelopes42@gmail.com");
            comprador.setIdLeilao(3);
            comprador.setAtivo(true);

            CompradorBiz compradorBiz = new CompradorBiz(comprador, compradorRepository);
            Boolean bizIsValid = compradorBiz.isValid(comprador);

            result = bizIsValid == true || bizIsValid == false;


        }catch (Exception ex){
            System.out.println(ex.getMessage());
            result = false;
        }

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void validAtivoTest(){
        Boolean expected = true;
        Boolean result = false;
        try{
            Comprador comprador = new Comprador();
            comprador.setIdComprador(0);
            comprador.setNome("Joaquim do teste");
            comprador.setCpf("01234567892");
            comprador.setDataNascimento(new Date());
            comprador.setTelefone("67992814411");
            comprador.setEmail("lhenriquelopes42@gmail.com");
            comprador.setIdLeilao(3);
            comprador.setAtivo(true);

            CompradorBiz compradorBiz = new CompradorBiz(comprador, compradorRepository);
            Boolean validAtivo = compradorBiz.validAtivo(comprador.getAtivo());

            result = validAtivo ;


        }catch (Exception ex){
            System.out.println(ex.getMessage());
            result = false;
        }

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void nomeUnicoTest(){
        Boolean expected = true;
        Boolean result = false;
        try{
            Comprador comprador = new Comprador();
            comprador.setIdComprador(0);
            comprador.setNome("Joaquim do teste");
            comprador.setCpf("01234567892");
            comprador.setDataNascimento(new Date());
            comprador.setTelefone("67992814411");
            comprador.setEmail("lhenriquelopes42@gmail.com");
            comprador.setIdLeilao(3);
            comprador.setAtivo(true);

            CompradorBiz compradorBiz = new CompradorBiz(comprador, compradorRepository);
            Boolean validAtivo = compradorBiz.nomeUnico(comprador.getNome());

            result = validAtivo;


        }catch (Exception ex){
            System.out.println(ex.getMessage());
            result = false;
        }

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void validarDataTest(){
        Boolean expected = true;
        Boolean result = false;
        try{
            Comprador comprador = new Comprador();
            comprador.setIdComprador(0);
            comprador.setNome("Joaquim do teste");
            comprador.setCpf("01234567892");
            comprador.setDataNascimento(new Date());
            comprador.setTelefone("67992814411");
            comprador.setEmail("lhenriquelopes42@gmail.com");
            comprador.setIdLeilao(3);
            comprador.setAtivo(true);

            CompradorBiz compradorBiz = new CompradorBiz(comprador, compradorRepository);
            Boolean validAtivo = compradorBiz.validarData(comprador.getDataNascimento());

            result = validAtivo ;


        }catch (Exception ex){
            System.out.println(ex.getMessage());
            result = false;
        }

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void validarTelefoneTest(){
        Boolean expected = true;
        Boolean result = false;
        try{
            Comprador comprador = new Comprador();
            comprador.setIdComprador(0);
            comprador.setNome("Joaquim do teste");
            comprador.setCpf("01234567892");
            comprador.setDataNascimento(new Date());
            comprador.setTelefone("67992814411");
            comprador.setEmail("lhenriquelopes42@gmail.com");
            comprador.setIdLeilao(3);
            comprador.setAtivo(true);

            CompradorBiz compradorBiz = new CompradorBiz(comprador, compradorRepository);
            Boolean validAtivo = compradorBiz.validarTelefone(comprador.getTelefone());

            result = validAtivo ;


        }catch (Exception ex){
            System.out.println(ex.getMessage());
            result = false;
        }

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void validaEmailTest(){
        Boolean expected = true;
        Boolean result = false;
        try{
            Comprador comprador = new Comprador();
            comprador.setIdComprador(0);
            comprador.setNome("Joaquim do teste");
            comprador.setCpf("01234567892");
            comprador.setDataNascimento(new Date());
            comprador.setTelefone("67992814411");
            comprador.setEmail("lhenriquelopes42@gmail.com");
            comprador.setIdLeilao(3);
            comprador.setAtivo(true);

            CompradorBiz compradorBiz = new CompradorBiz(comprador, compradorRepository);
            Boolean validAtivo = compradorBiz.validaEmail(comprador.getEmail());

            result = validAtivo ;


        }catch (Exception ex){
            System.out.println(ex.getMessage());
            result = false;
        }

        assertThat(result).isEqualTo(expected);
    }

}
