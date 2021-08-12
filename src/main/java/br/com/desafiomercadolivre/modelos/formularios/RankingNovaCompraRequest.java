package br.com.desafiomercadolivre.modelos.formularios;

import javax.validation.constraints.NotNull;

public class RankingNovaCompraRequest {

    @NotNull
    private Long idCompra;

    @NotNull
    private Long idDonoProduto;

    @Deprecated
    public RankingNovaCompraRequest(){

    }

    public RankingNovaCompraRequest(Long idCompra, Long idDonoProduto) {
        this.idCompra = idCompra;
        this.idDonoProduto = idDonoProduto;
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public Long getIdComprador() {
        return idDonoProduto;
    }

    @Override
    public String toString() {
        return "NovaCompraNFRequest{" +
                "idCompra=" + idCompra +
                ", idComprador=" + idDonoProduto +
                '}';
    }
}
