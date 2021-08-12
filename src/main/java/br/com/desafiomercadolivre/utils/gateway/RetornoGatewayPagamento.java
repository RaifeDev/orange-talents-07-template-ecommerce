package br.com.desafiomercadolivre.utils.gateway;

import br.com.desafiomercadolivre.modelos.NovaCompra;
import br.com.desafiomercadolivre.modelos.Transacao;
import org.springframework.stereotype.Component;

public interface RetornoGatewayPagamento {

    /**
     *
     * @param compra
     * @return uma nova transação em função do gateway especifico.
     */
    Transacao converterParaTransacao(NovaCompra compra);


}
