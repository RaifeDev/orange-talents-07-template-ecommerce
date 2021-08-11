package br.com.desafiomercadolivre.utils.gateway;

import br.com.desafiomercadolivre.modelos.NovaCompra;
import org.springframework.web.util.UriComponentsBuilder;

public interface Gateway {


    String retornarURI(NovaCompra compra, UriComponentsBuilder uriComponentsBuilder);


}
