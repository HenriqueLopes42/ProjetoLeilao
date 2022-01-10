package com.example.ProjetoLeilao.business;

import com.example.ProjetoLeilao.entities.*;
import com.example.ProjetoLeilao.repositories.*;

import java.util.*;

public class AnimalBiz {

    private AnimalRepository animalRepository;
    private Animal animal;
    private List<String> erros;

    private MedicoRepository medicoRepository;
    private CompradorRepository compradorRepository;
    private LeilaoRepository leilaoRepository;
    private VendedorRepository vendedorRepository;
    private RacaRepository racaRepository;


    public AnimalBiz(Animal animal,
                     AnimalRepository animalRepository,
                     MedicoRepository medicoRepository,
                     CompradorRepository compradorRepository,
                     LeilaoRepository leilaoRepository,
                     VendedorRepository vendedorRepository,
                     RacaRepository racaRepository){

        this.animalRepository = animalRepository;
        this.animal = animal;
        this.erros = new ArrayList<String>();

        this.medicoRepository = medicoRepository;
        this.compradorRepository = compradorRepository;
        this.leilaoRepository = leilaoRepository;
        this.vendedorRepository = vendedorRepository;
        this.racaRepository =racaRepository;


    }

    public Boolean isValid(){
        Boolean resultado;
        resultado = nomeUnico(animal.getNome());
        resultado = nomeValido(animal.getNome()) && resultado;
        resultado = precoValido(animal.getPreco()) && resultado;

        resultado = medicoExistente(animal.getIdMedico()) && resultado;
        resultado = medicoAtivo(animal.getIdMedico()) && resultado;

        resultado = compradorExistente(animal.getIdComprador()) && resultado;
        resultado = compradorAtivo(animal.getIdComprador()) && resultado;

        resultado = vendedorExistente(animal.getIdVendedor()) && resultado;
        resultado = vendedorAtivo(animal.getIdVendedor()) && resultado;

        resultado = leilaoExistente(animal.getIdLeilao()) && resultado;
        resultado = leilaoAtivo(animal.getIdLeilao()) && resultado;

        resultado = racaExistente(animal.getIdRaca()) && resultado;
        resultado = racaAtivo(animal.getIdRaca()) && resultado;

        resultado = verificarIdade(animal.getIdade()) && resultado;
        resultado = PesoValido(animal.getPesoArroba()) && resultado;



        return resultado;
    }
    // validação para alterar
    public Boolean isValidToAlter(){
        Boolean resultado;
        resultado = nomeValido(animal.getNome()) ;
        resultado = precoValido(animal.getPreco()) && resultado;

        resultado = medicoExistente(animal.getIdMedico()) && resultado;
        resultado = medicoAtivo(animal.getIdMedico()) && resultado;

        resultado = compradorExistente(animal.getIdComprador()) && resultado;
        resultado = compradorAtivo(animal.getIdComprador()) && resultado;

        resultado = vendedorExistente(animal.getIdVendedor()) && resultado;
        resultado = vendedorAtivo(animal.getIdVendedor()) && resultado;

        resultado = leilaoExistente(animal.getIdLeilao()) && resultado;
        resultado = leilaoAtivo(animal.getIdLeilao()) && resultado;

        resultado = racaExistente(animal.getIdRaca()) && resultado;
        resultado = racaAtivo(animal.getIdRaca()) && resultado;

        resultado = verificarIdade(animal.getIdade()) && resultado;
        resultado = PesoValido(animal.getPesoArroba()) && resultado;



        return resultado;
    }

    public Boolean nomeUnico(String nome){
        Integer quantidade = animalRepository.findByNome(nome).size();
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

    public Boolean precoValido(Float preco){

        if(preco >= 100 && preco <= 100000){
            return true;
        }else{
            erros.add("O preço deve ser mais que 100 e menor que 100.000");
            return false;
        }

    }

    public Boolean medicoExistente(Integer idMedico){
        Integer quantidade = medicoRepository.findByIdMedico(idMedico).size();
        if(quantidade > 0){
            return true;
        }else{
            erros.add("O id medico não existe.");
            return false;
        }
    }

    public Boolean medicoAtivo(Integer idMedico){
        Medico medico =  medicoRepository.findById(idMedico).get();

        if(medico.getAtivo()){
            return true;
        }else{
            erros.add("O medico não esta ativo.");
            return false;
        }
    }

    public Boolean compradorExistente(Integer idComprador){
        Integer quantidade = compradorRepository.findByIdComprador(idComprador).size();
        if(quantidade > 0){
            return true;
        }else{
            erros.add("O id Comprador não existe.");
            return false;
        }
    }

    public Boolean compradorAtivo(Integer idComprador){
        Comprador comprador =  compradorRepository.findById(idComprador).get();

        if(comprador.getAtivo()){
            return true;
        }else{
            erros.add("O comprador não esta ativo.");
            return false;
        }
    }





    public Boolean vendedorExistente(Integer idVendedor){
        Integer quantidade = vendedorRepository.findByIdVendedor(idVendedor).size();
        if(quantidade > 0){
            return true;
        }else{
            erros.add("O id vendedor não existe.");
            return false;
        }
    }

    public Boolean vendedorAtivo(Integer idVendedor){
        Vendedor vendedor =  vendedorRepository.findById(idVendedor).get();

        if(vendedor.getAtivo()){
            return true;
        }else{
            erros.add("O Vendedor não esta ativo.");
            return false;
        }
    }




    public Boolean leilaoExistente(Integer idLeilao){
        Integer quantidade = leilaoRepository.findByIdLeilao(idLeilao).size();
        if(quantidade > 0){
            return true;
        }else{
            erros.add("O id Leilao não existe.");
            return false;
        }
    }

    public Boolean leilaoAtivo(Integer idLeilao){
        Leilao leilao =  leilaoRepository.findById(idLeilao).get();

        if(leilao.getAtivo()){
            return true;
        }else{
            erros.add("O Leilao não esta ativo.");
            return false;
        }
    }


    public Boolean racaExistente(Integer idRaca){
        Integer quantidade = racaRepository.findByIdRaca(idRaca).size();
        if(quantidade > 0){
            return true;
        }else{
            erros.add("O id Raça não existe.");
            return false;
        }
    }

    public Boolean racaAtivo(Integer idRaca){
        Raca raca =  racaRepository.findById(idRaca).get();

        if(raca.getAtivo()){
            return true;
        }else{
            erros.add("A raca escolhida nao esta ativa.");
            return false;
        }
    }

    public Boolean verificarIdade(Integer idade){
        if(idade >= 2 && idade <=7 ){
            return true;
        }else{
            erros.add("A idade deve ser maior que 2 anos e menor que 7 anos.");
            return false;
        }
    }

    public Boolean PesoValido(Float peso){
        if(peso >= 100 && peso <= 600 ){
            return true;
        }else{
            erros.add("O peso deve estar entre 100 e 600.");
            return false;
        }
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(ArrayList<String> erros) {
        this.erros = erros;
    }
}
