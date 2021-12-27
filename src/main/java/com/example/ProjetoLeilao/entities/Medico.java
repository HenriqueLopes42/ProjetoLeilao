package com.example.ProjetoLeilao.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 10)
    @Pattern(regexp = "^[0-9]+", message = "O codigo precisa ter ao menos um caractere")
    private Integer idMedico;

    @Column(name = "nome", nullable = false, length = 50)
    @Pattern(regexp = "^[A-Za-z\s]{10,50}$", message = "O nome precisa ter entre 10 a 50 caracteres.")
    private String nome;

    @Column(name = "crmv", nullable = false, length = 10)
    @Pattern(regexp = "^[0-9]+", message = "CRMV precisa deve ser maior que 0")
    private Integer crmv;

    @Column(name = "data_nascimento", nullable = false, length = 10)
    @Pattern(regexp = "^[0-2][0-9]{3}/[0-1][0-9]/[0-3][0-9]", message = "Data de nascimento inválida")
    private Date dataNascimento;

    @Column(name = "telefone", nullable = false,  length = 16)
    @Pattern(regexp = "^\\([0-9]{2}\\)[0-9]{5}-[0-9]{4}$", message = "Numero de telefone invalido.")
    private String telefone;

    @Column(name = "email", nullable = false, length = 100)
    @Pattern(regexp = "^([0-9A-Za-z]+)(@{1})([A-Za-z]+)(\\.)([A-Za-z]{2,3})$ ", message = "Email invalido.")
    private String email;

    @Column(name = "ativo", nullable = false, length = 1)
    private Boolean ativo;

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCrmv() {
        return crmv;
    }

    public void setCrmv(Integer crmv) {
        this.crmv = crmv;
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
