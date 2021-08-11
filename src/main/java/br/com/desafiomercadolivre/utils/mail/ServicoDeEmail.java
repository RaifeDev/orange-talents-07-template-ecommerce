package br.com.desafiomercadolivre.utils.mail;

import br.com.desafiomercadolivre.modelos.NovaCompra;
import br.com.desafiomercadolivre.modelos.Pergunta;
import br.com.desafiomercadolivre.modelos.Produto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ServicoDeEmail {

    private static final Logger LOG = LoggerFactory.getLogger(ServicoDeEmail.class);


    public void enviarEmail(Pergunta pergunta, Produto produto){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(produto.getUsuarioProprietario().getUsername());
        simpleMailMessage.setFrom(pergunta.getUsuario().getUsername());
        simpleMailMessage.setSubject("Nova pergunta para o produto: " + produto.getNome());
        simpleMailMessage.setSentDate(new Date(System.currentTimeMillis()));
        simpleMailMessage.setText(pergunta.toString());

        LOG.info("Simulando envio de email...");
        LOG.info(simpleMailMessage.toString());
        LOG.info("Email enviado.");

    }

    public void EmaailSinalizaCompra(NovaCompra compra, Produto produto){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(produto.getUsuarioProprietario().getUsername());
        simpleMailMessage.setFrom(compra.getComprador().getUsername());
        simpleMailMessage.setSubject("Um novo produto vendido: " + produto.getNome());
        simpleMailMessage.setSentDate(new Date(System.currentTimeMillis()));
        simpleMailMessage.setText(compra.toString());

        LOG.info("Simulando envio de email...");
        LOG.info(simpleMailMessage.toString());
        LOG.info("Email enviado.");

    }





}
