package br.com.desafiomercadolivre.modelos.respostas;

import java.time.LocalDateTime;

public class HandleGenericResponse {

    private LocalDateTime instante;
    private String mensagem;
    private String causa;
    private Integer status;

    public HandleGenericResponse(String mensagem, String causa, Integer status) {
        this.instante = LocalDateTime.now();
        this.mensagem = mensagem;
        this.causa = causa;
        this.status = status;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getCausa() {
        return causa;
    }

    public Integer getStatus() {
        return status;
    }
}
