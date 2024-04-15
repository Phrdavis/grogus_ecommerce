package br.univille.projeto_capivara_magica.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;   
    private String cidade;
    private String filial;
    private String uf;
    private String cnpj;
    private LocalDateTime registro;

    public Fornecedor(String nome, String cidade, String filial, String uf, String cnpj) {
        this.nome = nome;
        this.cidade = cidade;
        this.filial = filial;
        this.uf = uf;
        this.cnpj = cnpj;
    }

    public Fornecedor() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getFilial() {
        return filial;
    }
    public void setFilial(String filial) {
        this.filial = filial;
    }
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public LocalDateTime getRegistro() {
        return registro;
    }
    public void setRegistro(LocalDateTime registro) {
        this.registro = registro;
    } 

}
