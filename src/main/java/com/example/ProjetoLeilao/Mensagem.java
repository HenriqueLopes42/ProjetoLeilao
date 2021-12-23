package com.example.ProjetoLeilao;

import java.util.List;

public class Mensagem {

    private String mensagem;

    private List<String> erros;

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public List<String> getErros() { return erros; }
    public void setErros(List<String> erros) { this.erros = erros; }

}
