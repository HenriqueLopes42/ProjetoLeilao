package com.example.ProjetoLeilao.entities;


import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Pattern(regexp = "^[0-9]{10}$", message = "Esse codigo precisa ser um numero inteiro.")
    private Integer idAnimal;

    @Column(name = "nome")
    @Pattern(regexp = "^[A-Za-z\s]{10,50}$", message = "O nome precisa ter entre 10 a 50 caracteres.")
    private String nome;

    @Column(name = "registro")
    @Pattern(regexp = "^([A-Z]{3}[0-9]{4})$", message = "o registro precisa ser valido.")
    private String registro;

    @Column(name = "preco")
    @Pattern(regexp = "^\\d*[0-9](\\.\\d*[0-9])?$", message = "Esse codigo precisa ser um numero inteiro.")
    private Float preco;

    @Column(name = "id_raca")
    @Pattern(regexp = "^[0-9]{10}$", message = "Esse codigo precisa ser um numero inteiro.")
    private Integer idRaca;

    @Column(name = "id_vendedor")
    @Pattern(regexp = "^[0-9]{10}$", message = "Esse codigo precisa ser um numero inteiro.")
    private Integer idVendedor;

    @Column(name = "id_comprador")
    @Pattern(regexp = "^[0-9]{10}$", message = "Esse codigo precisa ser um numero inteiro.")
    private Integer idComprador;

    @Column(name = "id_medico")
    @Pattern(regexp = "^[0-9]{10}$", message = "Esse codigo precisa ser um numero inteiro.")
    private Integer idMedico;

    @Column(name = "peso_arroba")
    @Pattern(regexp = "^[0-9]{10}$", message = "Esse codigo precisa ser um numero inteiro.")
    private Float pesoArroba;

    @Column(name = "idade")
    @Pattern(regexp = "^[0-9]{10}$", message = "Esse codigo precisa ser um numero inteiro.")
    private Integer idade;

    @Column(name = "id_leilao")
    @Pattern(regexp = "^[0-9]{10}$", message = "Esse codigo precisa ser um numero inteiro.")
    private Integer idLeilao;

    @Column(name = "ativo")
    private Boolean ativo;


    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Integer getIdRaca() {
        return idRaca;
    }

    public void setIdRaca(Integer idRaca) {
        this.idRaca = idRaca;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Integer getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Integer idComprador) {
        this.idComprador = idComprador;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public Float getPesoArroba() {
        return pesoArroba;
    }

    public void setPesoArroba(Float pesoArroba) {
        this.pesoArroba = pesoArroba;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getIdLeilao() {
        return idLeilao;
    }

    public void setIdLeilao(Integer idLeilao) {
        this.idLeilao = idLeilao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getNome() { return nome;}

    public void setNome(String nome) {this.nome = nome; }
}
