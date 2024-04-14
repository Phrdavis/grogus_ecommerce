package br.univille.projeto_capivara_magica.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private boolean disponibilidade;
    private String descricao;
    private int garantia;
    private String modelo;
    private long preco;

    @ManyToOne(targetEntity = Fornecedor.class)
    @JoinColumn(name="fornecedor_id")
    private Fornecedor fornecedor;

    @ManyToOne(targetEntity = Tipo_Produto.class)
    @JoinColumn(name="tipo_id")
    private Tipo_Produto tipo_produto; 

    @ManyToOne(targetEntity = Categoria_Produto.class)
    @JoinColumn(name="categoria_id")
    private Categoria_Produto categoria_produto;

    private LocalDateTime registro;

    public Produto(String nome, boolean disponibilidade, String descricao, int garantia, String modelo, long preco, Fornecedor fornecedor, Tipo_Produto tipo_produto, Categoria_Produto categoria_produto) {
        this.nome = nome;
        this.disponibilidade = disponibilidade;
        this.descricao = descricao;
        this.garantia = garantia;
        this.modelo = modelo;
        this.preco = preco;
        this.fornecedor = fornecedor;
        this.tipo_produto = tipo_produto;
        this.categoria_produto = categoria_produto;
    }

    public Produto() {
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

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public long getPreco() {
        return preco;
    }

    public void setPreco(long preco) {
        this.preco = preco;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Tipo_Produto getTipo_produto() {
        return tipo_produto;
    }

    public void setTipo_produto(Tipo_Produto tipo_produto) {
        this.tipo_produto = tipo_produto;
    }

    public Categoria_Produto getCategoria_produto() {
        return categoria_produto;
    }

    public void setCategoria_produto(Categoria_Produto categoria_produto) {
        this.categoria_produto = categoria_produto;
    }
    
    @PrePersist
    public void prePersist() {
        this.registro = LocalDateTime.now();
    }

    public LocalDateTime getRegistro() {
        return registro;
    }

    public void setRegistro(LocalDateTime registro) {
        this.registro = registro;
    }

    

}
