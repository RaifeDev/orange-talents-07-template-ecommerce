package br.com.desafiomercadolivre.modelos.formularios;

import br.com.desafiomercadolivre.modelos.NovaCompra;
import br.com.desafiomercadolivre.modelos.StatusRetornoPagSeguro;
import br.com.desafiomercadolivre.modelos.StatusTransacao;
import br.com.desafiomercadolivre.modelos.Transacao;
import br.com.desafiomercadolivre.utils.gateway.RetornoGatewayPagamento;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PagSeguroRequest implements RetornoGatewayPagamento {

    @NotBlank
    private String idTransacao;

    @NotNull
    private StatusRetornoPagSeguro status;

    public PagSeguroRequest(String idTransacao, StatusRetornoPagSeguro status) {
        this.idTransacao = idTransacao;
        this.status = status;
    }

    @Override
    public String toString() {
        return "PagSeguroRequest{" +
                "idTransacao='" + idTransacao + '\'' +
                ", status=" + status +
                '}';
    }

    public Transacao converterParaTransacao(NovaCompra compra) {

        return new Transacao(idTransacao, status.retornarStatus(), compra);

    }
}
