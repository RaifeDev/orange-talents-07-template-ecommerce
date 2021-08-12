package br.com.desafiomercadolivre;

import br.com.desafiomercadolivre.modelos.formularios.NovaCompraNFRequest;
import br.com.desafiomercadolivre.modelos.formularios.RankingNovaCompraRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class OutrosSistemasController {

    @PostMapping("/notas-fiscais")
    public void criaNota(@Valid @RequestBody NovaCompraNFRequest request) throws InterruptedException {
        System.out.println("Criando nota para " + request);
        Thread.sleep(150);
    }

    @PostMapping("/ranking")
    public void ranking(@Valid @RequestBody RankingNovaCompraRequest request) throws InterruptedException {
        System.out.println("criando ranking"+request);
        Thread.sleep(150);
    }



}
