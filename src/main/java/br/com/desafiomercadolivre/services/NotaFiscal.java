package br.com.desafiomercadolivre.services;

import br.com.desafiomercadolivre.modelos.NovaCompra;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class NotaFiscal {


    public void processa(NovaCompra compraSolicitada) {

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> request = Map.of("idCompra", compraSolicitada.getId(), "idComprador", compraSolicitada.getComprador());
        restTemplate.postForEntity("http://localhost:8080/notas-fiscais", request, String.class);

    }
}
