package br.com.senacsp.ProjetoPI.model;

import br.com.senacsp.ProjetoPI.enumeracoes.produto.Avaliacao;
import br.com.senacsp.ProjetoPI.enumeracoes.produto.Status;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String nome;
    @Column(length = 2000)
    private String detalhes;
    private Double preco;
    private Integer quantidade;
    @Enumerated
    private Avaliacao avaliacao;
    @Enumerated
    private Status status;
    @OneToMany
    private List<Imagem> urlImg;

    public Produto(Long id, String nome, String detalhes,
                   Double preco, Integer quantidade,
                   Avaliacao avaliacao, Status status, List<Imagem> urlImg) {
        this.id = id;
        this.nome = nome;
        this.detalhes = detalhes;
        this.preco = preco;
        this.quantidade = quantidade;
        this.avaliacao = avaliacao;
        this.status = Status.ATIVO;
        this.urlImg = urlImg;
    }

    public Produto(Long id, Status status) {
        this.id = id;
        this.status = status;
    }

    public Produto(String nome, String detalhes, Double preco,
                   Integer quantidade, Avaliacao avaliacao, Status status, List<Imagem> urlImg) {
        this.nome = nome;
        this.detalhes = detalhes;
        this.preco = preco;
        this.quantidade = quantidade;
        this.avaliacao = avaliacao;
        this.status = Status.ATIVO;
        this.urlImg = urlImg;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Imagem> getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(List<Imagem> urlImg) {
        this.urlImg = urlImg;
    }
}
