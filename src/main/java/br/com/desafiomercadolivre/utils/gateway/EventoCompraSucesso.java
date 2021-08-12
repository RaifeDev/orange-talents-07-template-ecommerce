package br.com.desafiomercadolivre.utils.gateway;

import br.com.desafiomercadolivre.modelos.NovaCompra;

public interface EventoCompraSucesso {
    void processa(NovaCompra compra);
}