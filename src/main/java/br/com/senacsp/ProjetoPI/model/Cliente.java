package br.com.senacsp.ProjetoPI.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true, updatable = false)
    private String cpf;
    private Date dataNascimento;
    private String genero;
    @Column(unique = true, updatable = false)
    private String usuario;
    private String senha;
    @OneToOne(cascade = CascadeType.ALL)
    private EnderecoFaturamento enderecoFaturamento;
    @OneToMany(cascade = CascadeType.ALL)
    private List<EnderecoEntrega> enderecoEntrega;

    public Cliente(Long id, String nome, String cpf, Date dataNascimento, String genero, String usuario, String senha, EnderecoFaturamento enderecoFaturamento, List<EnderecoEntrega> enderecoEntrega) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.usuario = usuario;
        this.senha = senha;
        this.enderecoFaturamento = enderecoFaturamento;
        this.enderecoEntrega = enderecoEntrega;
    }

    public Cliente(String nome, String cpf, Date dataNascimento, String genero, String usuario, String senha, EnderecoFaturamento enderecoFaturamento, List<EnderecoEntrega> enderecoEntrega) {

        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.usuario = usuario;
        this.senha = senha;
        this.enderecoFaturamento = enderecoFaturamento;
        this.enderecoEntrega = enderecoEntrega;
    }

    public Cliente(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public EnderecoFaturamento getEnderecoFaturamento() {
        return enderecoFaturamento;
    }

    public void setEnderecoFaturamento(EnderecoFaturamento enderecoFaturamento) {
        this.enderecoFaturamento = enderecoFaturamento;
    }

    public List<EnderecoEntrega> getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(List<EnderecoEntrega> enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
}
