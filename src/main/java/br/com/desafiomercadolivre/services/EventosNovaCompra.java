package br.com.desafiomercadolivre.services;

import br.com.desafiomercadolivre.modelos.NovaCompra;
import br.com.desafiomercadolivre.utils.gateway.EventoCompraSucesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EventosNovaCompra {

    @Autowired
    private Set<EventoCompraSucesso> eventosCompraSucesso;

    public void processa(NovaCompra compra) {
        if(compra.processadaComSucesso()) {
            eventosCompraSucesso.forEach(evento -> evento.processa(compra));
        }
        else {
            //eventosFalha
        }
    }
}