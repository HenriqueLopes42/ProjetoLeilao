package com.example.ProjetoLeilao.entities;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name="leilao")
public class Leilao {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = true, length = 10)
    @Pattern(regexp = "^[0-9]{1,100}$", message = "o codigo do leilão precisa ser de 1 a 100")
    private Integer idLeilao;

    @Column(name = "nome", nullable = false, length = 50)
    @Pattern(regexp = "^[A-Za-z-0-9\s]{10,50}$", message = "O nome do Evento de Leilão deve ter entre 10 e 50 caracteres")
    private String nome;

    @Column(name = "descricao", nullable = false, length = 100)
    @Pattern(regexp = "^[A-z0-9]{20,100}$", message = "A descricao deve ter uim minimo de 20 caracteres e um maximo de 100.")
    private String descricao;

    @Column(name = "data", nullable = false, length = 10)
    @Pattern(regexp = "^[0-3][0-9]/[0-1][0-9]/[0-9]{4}$", message = "Data incorreta")
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
