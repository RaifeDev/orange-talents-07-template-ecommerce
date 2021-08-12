package br.com.desafiomercadolivre.services;

import br.com.desafiomercadolivre.modelos.NovaCompra;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class Ranking {


    public void processa(NovaCompra compraSolicitada) {

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> request = Map.of("idCompra", compraSolicitada.getId(), "idDonoProduto",
                compraSolicitada.getProduto().getUsuarioProprietario());
        restTemplate.postForEntity("http://localhost:8080/ranking", request, String.class);

    }
}
