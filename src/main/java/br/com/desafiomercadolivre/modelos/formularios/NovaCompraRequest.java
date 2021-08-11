package br.com.desafiomercadolivre.modelos.formularios;

import br.com.desafiomercadolivre.annotations.IdExiste;
import br.com.desafiomercadolivre.modelos.GatewayPagamento;
import br.com.desafiomercadolivre.modelos.NovaCompra;
import br.com.desafiomercadolivre.modelos.Produto;
import br.com.desafiomercadolivre.modelos.Usuario;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class NovaCompraRequest {

    @IdExiste(domainClass = Produto.class, fieldName = "id")
    @NotNull(message = "É necessário informar o id do produto desejado.")
    private Long produto;

    @Positive
    @NotNull(message = "É necessário informar uma quantidade positiva para adquirir o produto.")
    private Integer quantidade;

    @Enumerated
    private GatewayPagamento gatewayDePagamento;

    @Deprecated
    public NovaCompraRequest(){}

    public NovaCompraRequest(Long produto, Integer quantidade, GatewayPagamento gatewayDePagamento) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.gatewayDePagamento = gatewayDePagamento;
    }

    public Long getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public GatewayPagamento getGatewayDePagamento() {
        return gatewayDePagamento;
    }

    @Override
    public String toString() {
        return "NovaCompraRequest{" +
                "produto=" + produto +
                ", quantidade=" + quantidade +
                ", gatewayDePagamento=" + gatewayDePagamento +
                '}';
    }

    public NovaCompra converterParaNovaCompra(Usuario usuario, Produto produtoSelecionado) {

        return new NovaCompra(produtoSelecionado, quantidade, usuario, gatewayDePagamento);
    }
}
