package com.example.ProjetoLeilao.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "comprador")
public class Comprador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false, length = 10)
    @Pattern(regexp = "^[0-9]{10}$", message = "Esse codigo precisa ser um numero inteiro.")
    private Integer idComprador;

    @Column(name = "nome",nullable = false, length = 50)
    @Pattern(regexp = "[A-z]{10,50}", message = "O nome deve ter entre 10 e 50 caracteres")
    private String nome;

    @Column(name = "cpf",nullable = false, length = 15)
    @Pattern(regexp = "/^(\\d{2}\\.?\\d{3}\\.?\\d{3}\\/?\\d{4}-?\\d{2})$/", message = " o cpf deve ser valido")
    private String cpf;

    @Column(name = "data_nascimento",nullable = false, length = 10)
    @Pattern(regexp ="\\d{4}-[01]\\d-[0-3]\\d", message = " a data deve ser valida")
    private Date dataNascimento;

    @Column(name = "telefone",nullable = false, length = 15)
    @Pattern(regexp = "^\\(\\d{2}\\)\\s[0-9]{5}-[0-9]{4}$\n", message = "O número de celular deve ser válido")
    private String telefone;

    @Column(name = "email",nullable = false, length = 100)
    @Pattern(regexp = "^([0-9A-Za-z]+)(@{1})([A-Za-z]+)(.)([A-Za-z]{2,3})$", message = "O e-mail deve ser válido")
    private String email;

    @Column(name = "id_leilao",nullable = false, length = 10)
    @Pattern(regexp = "^[0-9]{10}$", message = "O código deve ser um número inteiro")
    private String idLeilao;

    @Column(name = "ativo")
    private Boolean ativo;

    public Integer getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Integer idComprador) {
        this.idComprador = idComprador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdLeilao() {
        return idLeilao;
    }

    public void setIdLeilao(String idLeilao) {
        this.idLeilao = idLeilao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
