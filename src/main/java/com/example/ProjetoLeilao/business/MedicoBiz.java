package com.example.ProjetoLeilao.business;

import com.example.ProjetoLeilao.entities.Medico;
import com.example.ProjetoLeilao.repositories.MedicoRepository;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MedicoBiz {
    MedicoRepository medicoRepository;
    private Medico medico;
    private ArrayList<String> erros;

    public MedicoBiz(Medico medico, MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
        this.medico = medico;
        this.erros = new ArrayList<>();
    }

    public MedicoRepository getMedicoRepository() {
        return medicoRepository;
    }

    public void setMedicoRepository(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public ArrayList<String> getErros() {
        return erros;
    }

    public void setErros(ArrayList<String> erros) {
        this.erros = erros;
    }

    public Boolean isValid() {
        Boolean resultado;
        resultado = nomeUnico(medico.getNome());
        resultado = tamanhoNomeValido(medico.getNome()) && resultado;
        resultado = nomeIniciaMaiuscula(medico.getNome()) && resultado;
        resultado = validaDataNascimento(medico.getDataNascimento()) && resultado;
        resultado = validaTelefone(medico.getTelefone()) && resultado;
        resultado = validaEmail(medico.getEmail()) && resultado;
        resultado = validaCrmv(medico.getCrmv()) && resultado;
        return resultado;
    }

    public Boolean nomeUnico(String nome){

        Integer quantidade = medicoRepository.findByNome(nome).size();
        if (quantidade == 0) {
            return true;
        } else {
            erros.add("Não é possível cadastrar dois vendedores com o mesmo nome :(");
            return false;
        }
    }

    public Boolean tamanhoNomeValido( String nome){
        Integer tamanho = nome.length();
        if (tamanho >= 10 && tamanho <= 50){
            return true;
        } else {
            erros.add("O tamanho do nome deve ter pelo menos 10 caracteres");
            return false;
        }
    }

    public Boolean nomeIniciaMaiuscula( String nome ){

        Boolean certo = nome.matches("^[A-Z]");
        if (!certo){
            erros.add("O nome deve iniciar com letra maiuscula");
        }
        return certo;
    }

    public Boolean validaDataNascimento(Date data) {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String s = formatter.format(data);
        System.out.println(s);
        Boolean certo = s.matches("^[0-2][0-9]{3}/[0-1][0-9]/[0-3][0-9]");
        if (!certo)
            erros.add("A data de nascimento inserida é inválida.");
        return certo;
    }

    public Boolean validaTelefone(String telefone) {
        Boolean certo = telefone.matches("^([1-9]{2})[9][0-9]{4}[0-9]{4}$");
        if (!certo)
            erros.add("O telefone deve estar no formato XXXXXXXXXXX");
        return certo;
    }

    public Boolean validaEmail(String email) {
        Boolean certo = email.matches("^([0-9A-Za-z]+)(@{1})([A-Za-z]+)(\\.)([A-Za-z]{2,3})");
        if (!certo)
            erros.add("O endereco de email não segue o padrão");
        return certo;
    }

    public Boolean validaCrmv(Integer crmv) {
        if (crmv > 0)
            return true;
        return false;
    }
}
