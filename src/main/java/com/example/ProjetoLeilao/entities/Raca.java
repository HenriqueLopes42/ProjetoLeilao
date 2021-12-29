package com.example.ProjetoLeilao.entities;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="raca")
public class Raca {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private Integer idRaca;

    @Column (name="nome", nullable = false, length = 50)
    @Pattern(regexp = "^[A-Za-z\s]{4,50}$", message = "O nome da raça deve ter 4 ou mais caractéres.")
    private String nome;

    @Column (name="descricao", nullable = false, length = 100)
    @Pattern(regexp = "^[A-Za-z\s]{10,100}$", message = "A descrição da raça deve ter 10 ou mais caractéres.")
    private String descricao;

    @Column (name="ativo")
    private Boolean ativo;

    public Integer getIdRaca() { return idRaca; }
    public void setIdRaca(Integer idRaca) { this.idRaca = idRaca; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}
