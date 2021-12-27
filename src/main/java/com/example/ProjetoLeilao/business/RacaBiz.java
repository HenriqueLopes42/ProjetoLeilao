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
        resultado = racaUnica(this.raca.getNome());
        resultado = tamanhoDoNomeValido(this.raca.getNome());
        resultado = tamanhoDescricao(this.raca.getDescricao());
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

   public Boolean isValid(Raca r){
        this.raca = r;
        return isValid();
   }

   public Boolean racaUnica(String nome){
        Integer quantidade = racaRepository.findByNome(nome).size();
        if(quantidade==0){
            return true;
        } else{
            erros.add("A raça já existe no sistema.");
            return false;
        }
   }

   public Boolean tamanhoDoNomeValido(String nome){
        Integer tamanho = nome.length();
        if (tamanho>= 4){
            return true;
        }else{
            erros.add("O nome da raça deve ter 4 ou mais caractéres.");
            return false;
        }
   }

   public Boolean tamanhoDescricao(String descricao){
        Integer tamanho = descricao.length();
        if (tamanho >= 10){
            return true;
        }else{
            erros.add("A descrição da raça deve ter 10 ou mais caractéres.");
            return false;
        }
   }

}
