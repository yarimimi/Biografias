package xyz.michelle.biografias;

import java.io.Serializable;

import java.io.Serializable;

public class Bio implements Serializable {
    private String nome;
    private int idade;
    private String profissao;
    private String resumo;
    private int foto;

    public Bio() {
    }

    public Bio(String nome, int idade, String profissao, String resumo, int foto) {
        this.nome = nome;
        this.idade = idade;
        this.profissao = profissao;
        this.resumo = resumo;
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getProfissao() {
        return profissao;
    }

    public String getResumo() {
        return resumo;
    }

    public int getFoto() {
        return foto;
    }
}
