package br.com.desafiomercadolivre.modelos.respostas;

import br.com.desafiomercadolivre.modelos.Pergunta;

import java.time.LocalDateTime;

public class PerguntaResponse {

    private String titulo;

    private LocalDateTime dataCriacao;

    private String usuario;

    public PerguntaResponse(Pergunta pergunta) {
        this.titulo = pergunta.getTitulo();
        this.dataCriacao = pergunta.getDataCriacao();
        this.usuario = pergunta.getUsuario().getUsername();
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getUsuario() {
        return usuario;
    }
}
