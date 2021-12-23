package com.example.ProjetoLeilao.business;

import com.example.ProjetoLeilao.entities.Leilao;
import com.example.ProjetoLeilao.repositories.LeilaoRepository;

import java.util.ArrayList;
import java.util.List;

public class LeilaoBiz {
    LeilaoRepository leilaoRepository;
    private Leilao leilao;
    private List<String> erros;

    /*public Boolean isValid(){
        Boolean resultado;
        return resultado;
    }*/

    public LeilaoBiz(Leilao l, LeilaoRepository leilaoRepository){
        erros = new ArrayList<>();
        this.leilao = l;
        this.leilaoRepository = leilaoRepository;
    }

    /*public Boolean isValid(Leilao l){
        this.leilao = l;
        return isValid();
    }*/





}
