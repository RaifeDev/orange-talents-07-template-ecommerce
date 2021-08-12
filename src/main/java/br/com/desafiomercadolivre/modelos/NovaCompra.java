package br.com.desafiomercadolivre.modelos;

import br.com.desafiomercadolivre.modelos.formularios.PagSeguroRequest;
import br.com.desafiomercadolivre.utils.gateway.RetornoGatewayPagamento;
import org.springframework.util.Assert;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_compras")
public class NovaCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "É necesário informar o produto.")
    private Produto produto;

    @Positive
    @NotNull(message = "É Necessário informar uma quantidade.")
    private Integer quantidade;

    @ManyToOne
    @NotNull
    private Usuario comprador;

    @Enumerated(EnumType.STRING)
    private GatewayPagamento gatewayDePagamento;

    @Enumerated(EnumType.STRING)
    private StatusCompra statusCompra;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.MERGE)
    private Set<Transacao> transacoes = new HashSet<>();

    @Deprecated
    public NovaCompra(){

    }

    public NovaCompra(Produto produto, Integer quantidade, Usuario comprador, GatewayPagamento gatewayDePagamento) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.comprador = comprador;
        this.gatewayDePagamento = gatewayDePagamento;
        this.statusCompra = StatusCompra.INICIADA;
    }

    public Long getId() {
        return id;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public String retornarUrlGateway(UriComponentsBuilder uriComponentsBuilder){
        return this.gatewayDePagamento.retornarURI(this, uriComponentsBuilder);
    }

    @Override
    public String toString() {
        return "NovaCompra{" +
                "id=" + id +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                ", comprador=" + comprador +
                ", gatewayDePagamento=" + gatewayDePagamento +
                ", statusCompra=" + statusCompra +
                '}';
    }

    public Produto getProduto() {
        return produto;
    }

    public void adicionaTransacao(RetornoGatewayPagamento formulario) {
        Transacao novaTransacao = formulario.converterParaTransacao(this);

        Assert.isTrue(!this.transacoes.contains(novaTransacao), "Já existe uma transação igual a essa sendo processada.");

        Assert.isTrue(transacoesConcluidasComSucesso().isEmpty(), "Essa compra já foi concluida com sucesso.");
        this.transacoes.add(novaTransacao);
    }

    private Set<Transacao> transacoesConcluidasComSucesso(){
        Set<Transacao> transacoesConcluidasComSucesso = this.transacoes.stream()
                .filter(Transacao::concluidaComSucesso).collect(Collectors.toSet());
        Assert.isTrue(transacoesConcluidasComSucesso.size() <= 1,
                "Deu ruim! tem mais de uma transação concluida para esta compra: " + this.id);
        return transacoesConcluidasComSucesso;
    }

    public boolean processadaComSucesso() {
        return !transacoesConcluidasComSucesso().isEmpty();
    }
}
