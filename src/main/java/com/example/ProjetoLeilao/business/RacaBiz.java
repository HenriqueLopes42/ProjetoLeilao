package com.example.ProjetoLeilao.business;

import com.example.ProjetoLeilao.entities.Raca;
import com.example.ProjetoLeilao.repositories.RacaRepository;

import java.util.ArrayList;
import java.util.List;

public class RacaBiz {
    RacaRepository racaRepository;
    private Raca raca;

    private List<String> erros;
    public List<String> getErros(){
        return erros;
    }
    public void setErros(List<String> erros){
        this.erros = erros;
    }

   public RacaBiz(Raca r, RacaRepository racaRepository){
        erros = new ArrayList<>();
        this.raca = r;
        this.racaRepository = racaRepository;
   }

   public Boolean isValid(){
        Boolean resultado;
        resultado = validAtivoRaca(this.raca.getAtivo());
        return resultado;
   }

   public Boolean validAtivoRaca(Boolean ativo){
        if (!ativo){
            erros.add("A raça deve estar ativada");
            return false;
        }else {
            return true;
        }
   }
}
