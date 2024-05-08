package br.univille.projeto_capivara_magica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Avaliacao_Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String comentario;

    @ManyToOne(targetEntity = Produto.class)
    @JoinColumn(name="produto_id")
    private Produto produto;
    private float nota;

    
    public Avaliacao_Produto(String comentario, Produto produto, float nota) {
        this.comentario = comentario;
        this.produto = produto;
        this.nota = nota;
    }
    
    public Avaliacao_Produto() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public float getNota() {
        return nota;
    }
    public void setNota(float nota) {
        this.nota = nota;
    }


    
}
