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

    public CompradorBiz(Comprador c, CompradorRepository compradorRepository){
        erros = new ArrayList<>();
        this.comprador = c;
        this.compradorRepository = compradorRepository;
    }

    public Boolean isValid(){
        Boolean resultado;
        resultado = nomeUnico(this.comprador.getNome());
        resultado =  tamanhoDoNomeValido(this.comprador.getNome()) && resultado;
        resultado = nomeIniciaMaiuscula(this.comprador.getNome()) && resultado;
        resultado = validarData(this.comprador.getDataNascimento()) && resultado;
        resultado = validarTelefone((this.comprador.getTelefone())) && resultado;
        resultado = validarEmail(this.comprador.getEmail()) && resultado;
        resultado = validAtivoLeilao(this.leilao.getAtivo()) && resultado;

        return resultado;
    }

    public Boolean isValid(Comprador c){
        this.comprador = c;
        return isValid();
    }

    public Boolean validAtivoLeilao(Boolean ativo){
        if (!ativo){
            erros.add("O leilao deve estar ativo");
            return false;
        }else {
            return true;
        }
    }

    // validar para que nao tenha um nome repetido
    public Boolean nomeUnico(String nome){

        Integer quantidade = compradorRepository.findByNome(nome).size();
        if (quantidade == 0) {
            return true;
        } else {
            erros.add("O Nome já existe no sistema.");
            return false;
        }
    }

    // tamanho do nome deve ser maiaor que 10
    public Boolean tamanhoDoNomeValido( String nome){
        Integer tamanho = nome.length();
        if (tamanho >= 10 ){
            return true;
        } else {
            erros.add("O tamanho do nome deve ser ter 10 ou mais caracteres");
            return false;
        }
    }

    // o nome deve iniciar com letra maiuscula
    public Boolean nomeIniciaMaiuscula( String nome ){

        Boolean certo = nome.matches("^[A-Z]]");
        if (!certo){
            erros.add("O nome deve iniciar com maiuscula");
        }
        return certo;

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

        if (tel == null || !tel.matches("^\\(?\\d{2}\\)?[\\s-]?\\d{4}-?\\d{4}$")) {
            return true;
        } else {
            erros.add("Telefone invalido");
            return false;
        }
    }

    public Boolean validarEmail ( String email) {

        if (email == null || email.matches("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$()")) {
            return true;

        } else {
            erros.add("Email invalido: ");
            return false;
        }
    }


        public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }



}
