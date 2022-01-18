package com.example.ProjetoLeilao.business;

import com.example.ProjetoLeilao.entities.Comprador;
import com.example.ProjetoLeilao.entities.Leilao;
import com.example.ProjetoLeilao.repositories.CompradorRepository;
import com.example.ProjetoLeilao.repositories.LeilaoRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompradorBiz {

    LeilaoRepository leilaoRepository;
    CompradorRepository compradorRepository;
    public Leilao leilao;
    private Comprador comprador;
    private List<String> erros;
    private boolean incluindo;

    public CompradorBiz(Comprador c, CompradorRepository compradorRepository){

        if (c.getIdComprador() == 0 ){
            this.incluindo = true;
        } else {
            this.incluindo = false;
        }

        erros = new ArrayList<>();
        this.comprador = c;
        this.compradorRepository = compradorRepository;
    }

    public Boolean isValid(){
        Boolean resultado = true;


        if (this.incluindo) {
            resultado = nomeUnico(this.comprador.getNome());
        }
        resultado = nomeValido(this.comprador.getNome()) && resultado;
        resultado = validarData(this.comprador.getDataNascimento()) && resultado;
        resultado = validarTelefone((this.comprador.getTelefone())) && resultado;
        resultado = validaEmail(this.comprador.getEmail()) && resultado;
        resultado = validAtivo(this.comprador.getAtivo()) && resultado;
        resultado = validarTelefone(this.comprador.getTelefone()) && resultado;


        return resultado;
    }

    public Boolean isValid(Comprador c){
        this.comprador = c;
        return isValid();
    }

    public Boolean validAtivo(Boolean ativo){
        if (!ativo){
            erros.add("O comprador deve estar ativo");
            return false;
        }else {
            return true;
        }
    }

    public Boolean nomeUnico(String nome){
        Integer quantidade = compradorRepository.findByNome(nome).size();
        if(quantidade == 0){
            return true;
        }else{
            erros.add("O nome ja existe");
            return false;
        }
    }

    public Boolean nomeValido(String nome){
        Integer numeroDeLetras = nome.length();
        if(numeroDeLetras >=10 && numeroDeLetras <= 50){
            return true;
        }else{
            erros.add("O nome deve conter um minimo de 10 digitos e um maximo de 50 digitos.");
            return false;
        }
    }

    public Boolean validarData( Date data ){

        Date date = new Date();
        String dateToStr = String.format(("%1$tY-%1$tm-%1$td"), date);

          if (data == null || dateToStr.matches(("\\d{4}-[01]\\d-[0-3]\\d"))) {
            return true;
        } else {
               erros.add("Data invalida");
               return false;
        }

    }
    public Boolean validarTelefone( String tel) {

        if (tel == null || !tel.matches("^\\(\\d{2}\\)\\s[0-9]{5}-[0-9]{4}$\n")) {
            return true;
        } else {
            erros.add("Telefone invalido");
            return false;
        }
    }

    public Boolean validaEmail(String email) {
        Boolean certo = email.matches("^([0-9A-Za-z]+)(@)([A-Za-z]+)(\\.)([A-Za-z]{2,3})");
        if (!certo)
            erros.add("O endereco de email não segue o padrão");
        return certo;
    }


        public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }



}
