package br.com.desafiomercadolivre.modelos.formularios;

import br.com.desafiomercadolivre.modelos.NovaCompra;
import br.com.desafiomercadolivre.modelos.StatusTransacao;
import br.com.desafiomercadolivre.modelos.Transacao;
import br.com.desafiomercadolivre.utils.gateway.RetornoGatewayPagamento;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class PayPalRequest implements RetornoGatewayPagamento {

    @Min(0)
    @Max(1)
    private Integer status;

    @NotBlank
    private String idTransacao;


    public PayPalRequest(Integer status, String idTransacao) {
        this.status = status;
        this.idTransacao = idTransacao;
    }

    public Transacao converterParaTransacao(NovaCompra compra) {
        StatusTransacao statusCalculado = this.status == 0? StatusTransacao.Erro : StatusTransacao.Sucesso;
        return new Transacao(idTransacao, statusCalculado, compra);

    }


}

