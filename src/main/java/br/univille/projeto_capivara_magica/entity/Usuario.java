package br.univille.projeto_capivara_magica.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int idade;
    private String cpf;
    private String email;
    private String telefone;
    private String senha;

    @Column(columnDefinition = "BOOLEAN DEFAULT 1")
    private Boolean ativo;

    @ManyToOne(targetEntity = Tipo_Usuario.class)
    @JoinColumn(name="tipo_id")
    private Tipo_Usuario tipo;

    private LocalDateTime registro;

    public Usuario(String nome, int idade, String cpf, String email, String telefone, String senha, Boolean ativo, Tipo_Usuario tipo) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.ativo = ativo;
        this.tipo = tipo;
    }

    public Usuario() {
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
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Boolean getAtivo() {
        return ativo;
    }
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    public Tipo_Usuario getTipo() {
        return tipo;
    }
    public void setTipo(Tipo_Usuario tipo) {
        this.tipo = tipo;
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
