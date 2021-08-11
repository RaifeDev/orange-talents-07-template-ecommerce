package br.com.desafiomercadolivre.modelos;

import br.com.desafiomercadolivre.utils.gateway.Gateway;
import org.springframework.web.util.UriComponentsBuilder;

public enum GatewayPagamento implements Gateway {

    PAGSEGURO{
        @Override
        public String retornarURI(NovaCompra compra, UriComponentsBuilder uriComponentsBuilder) {
            String urlPagSeguro = uriComponentsBuilder.path("/retorno-pagseguro/{id}")
                    .buildAndExpand(compra.getId()).toString();

            return "pagseguro.com/"+ compra.getId() + "?redirectUrl="+ urlPagSeguro;
        }
    },
    PAYPAL {
        @Override
        public String retornarURI(NovaCompra compra, UriComponentsBuilder uriComponentsBuilder) {
            String urlPayPal = uriComponentsBuilder.path("/retorno-paypal/{id}")
                    .buildAndExpand(compra.getId()).toString();

            return "paypal.com/"+ compra.getId() + "?redirectUrl="+ urlPayPal;
        }
    };



}
