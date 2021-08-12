package br.com.desafiomercadolivre.controladores;

import br.com.desafiomercadolivre.modelos.NovaCompra;
import br.com.desafiomercadolivre.modelos.Transacao;
import br.com.desafiomercadolivre.modelos.formularios.PagSeguroRequest;
import br.com.desafiomercadolivre.modelos.formularios.PayPalRequest;
import br.com.desafiomercadolivre.repositorios.NovaCompraRepository;
import br.com.desafiomercadolivre.services.EventosNovaCompra;
import br.com.desafiomercadolivre.services.NotaFiscal;
import br.com.desafiomercadolivre.services.Ranking;
import br.com.desafiomercadolivre.utils.gateway.RetornoGatewayPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class FechamentoDeCompraController {

    @Autowired
    private NovaCompraRepository novaCompraRepository;

    @Autowired
    private NotaFiscal notaFiscal;

    @Autowired
    private Ranking ranking;

    @Autowired
    private EventosNovaCompra eventosNovaCompra;



    ///retorno-pagseguro/{id}

    @PostMapping("retorno-pagseguro/{id}")
    @Transactional
    public String processaPagamentoPagSeguro(@PathVariable("id") Long idCompra,
                                               @RequestBody @Valid PagSeguroRequest formulario){

        return processa(idCompra, formulario);
    }

    @PostMapping("retorno-paypal/{id}")
    @Transactional
    public String processaPagamentoPayPal(@PathVariable("id") Long idCompra,
                                    @RequestBody @Valid PayPalRequest formulario){

        return processa(idCompra, formulario);
    }

    private String processa(Long idCompra, RetornoGatewayPagamento retornoGatewayPagamento){
        NovaCompra compraSolicitada = novaCompraRepository.getById(idCompra);
        compraSolicitada.adicionaTransacao(retornoGatewayPagamento);
        novaCompraRepository.save(compraSolicitada);

        eventosNovaCompra.processa(compraSolicitada);

        return compraSolicitada.toString();
    }




}
