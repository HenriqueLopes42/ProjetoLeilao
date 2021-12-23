package com.example.ProjetoLeilao.entities;

import javax.persistence.*;

@Entity
@Table(name="raca")
public class Raca {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="id", nullable = false, length = 10)
    private Integer idRaca;

    @Column (name="nome")
    private String nome;

    @Column (name="descricao")
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
