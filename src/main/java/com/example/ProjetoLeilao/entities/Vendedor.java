package com.example.ProjetoLeilao.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 10 )
    @Pattern(regexp = "^[0-9]{10}$", message = "O código deve ser inteiro")
    private Integer idVendedor;

    @Column(name = "nome", nullable = false, length = 50)
    @Pattern(regexp = "^[A-Z][a-z]{9,49}$", message = "O nome deve ter entre 10 e 50 caracteres")
    private String nome;

    @Column(name = "cpf", nullable = false, length = 15)
    @Pattern(regexp = "^[0-9]{3}(\\.\\d*[0-9]{3})(\\.\\d*[0-9]{3})-[0-9]{2}$", message = "CPF inválido")
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)
    @Pattern(regexp = "^[0-3][0-9]/[0-1][0-9]/[0-9]{2}$", message = "Data de nascimento inválida")
    private Date dataNascimento;

    @Column(name = "telefone", nullable = false, length = 11)
    @Pattern(regexp = "^\\([0-9]{2}\\)[0-9]{5}-[0-9]{4}$", message = "Numero de telefone invalido.")
    private String telefone;

    @Column(name = "email", nullable = false, length = 100)
    @Pattern(regexp = "^[A-z0-9_]{1,20}@[A-z]{1,15}\\.([A-z]{1,10}|[A-z]{1,10}\\.[A-z]{1,5})$", message = "Email invalido.")
    private String email;

    @Column(name = "ativo", nullable = false, length = 1)
    private Boolean ativo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
