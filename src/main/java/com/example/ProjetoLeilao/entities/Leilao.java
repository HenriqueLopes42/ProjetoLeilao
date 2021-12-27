package com.example.ProjetoLeilao.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name="leilao")
public class Leilao {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, length = 10)
    @Pattern(regexp = "^[0-9]{10}$", message = "Esse codigo precisa ser um numero inteiro.")
    private Integer idLeilao;

    @Column(name = "nome", nullable = false, length = 50)
    @Pattern(regexp = "^[A-z]{10,50}$", message = "O nome deve ter um minimo de 10 e um maximo de 50 caracteres.")
    private String nome;

    @Column(name = "descricao", nullable = false, length = 100)
    @Pattern(regexp = "^[A-z0-9]{20,100}$", message = "A descricao deve ter uim minimo de 20 caracteres e um maximo de 100.")
    private String descricao;

    @Column(name = "data", nullable = false)
    @Pattern(regexp = "^([1-9]|0[1-9]|[1,2][0-9]|3[0,1])/([1-9]|1[0,1,2])/\\d{4}$", message = " a data deve ser seguir o padrão")
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

    public Integer getIdLeilao() {
        return idLeilao;
    }

    public void setIdLeilao(Integer idLeilao) {
        this.idLeilao = idLeilao;
    }
}
