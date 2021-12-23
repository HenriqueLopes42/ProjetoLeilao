package com.example.ProjetoLeilao.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="leilao")
public class Leilao {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer idLeilao;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data")
    private Date data;

    @Column(name = "ativo")
    private Boolean ativo;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }

    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }

}
