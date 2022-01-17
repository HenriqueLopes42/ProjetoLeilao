package com.example.ProjetoLeilao.business;

import com.example.ProjetoLeilao.entities.Leilao;
import com.example.ProjetoLeilao.repositories.LeilaoRepository;

import java.util.ArrayList;
import java.util.List;

public class LeilaoBiz {
    LeilaoRepository leilaoRepository;
    private Leilao leilao;
    private List<String> erros;

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public LeilaoBiz(Leilao l, LeilaoRepository leilaoRepository){
        erros = new ArrayList<>();
        this.leilao = l;
        this.leilaoRepository = leilaoRepository;
    }


    public Boolean isValid() {
        Boolean resultado;
        resultado = nomeEventoUnico(this.leilao.getNome());
        return resultado;
    }

    public Boolean nomeEventoUnico (String nome){ // procura se nao existe outro evento já registrado com o mesmo nome
        Integer quantidade = leilaoRepository.findByNome(nome).size();
        if(quantidade == 0 ){
            return true;
        } else {
            erros.add("O Nome do Evento Leilão já existe no sistema.");
            return false;
        }
    }




}
