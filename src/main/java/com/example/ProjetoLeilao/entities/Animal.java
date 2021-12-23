package com.example.ProjetoLeilao.entities;


import javax.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idAnimal;

    @Column(name = "registro")
    private String registro;

    @Column(name = "preco")
    private Float preco;

    @Column(name = "id_raca")
    private Integer idRaca;

    @Column(name = "id_vendedor")
    private Integer idVendedor;

    @Column(name = "id_comprador")
    private Integer idComprador;

    @Column(name = "id_medico")
    private Integer idMedico;

    @Column(name = "peso_arroba")
    private Float pesoArroba;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "id_leilao")
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
}
