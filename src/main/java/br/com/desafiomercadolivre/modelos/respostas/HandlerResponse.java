package br.com.desafiomercadolivre.modelos.respostas;

import java.time.LocalDateTime;

public class HandlerResponse {

    private String exception;
    private Integer status;
    private String campo;
    private String msg;
    private LocalDateTime instante;

    public HandlerResponse(String exception, Integer status, String campo, String msg) {
        this.exception = exception;
        this.status = status;
        this.campo = campo;
        this.msg = msg;
        this.instante = LocalDateTime.now();
    }

    public String getException() {
        return exception;
    }

    public Integer getStatus() {
        return status;
    }

    public String getCampo() {
        return campo;
    }

    public String getMsg() {
        return msg;
    }

    public LocalDateTime getInstante() {
        return instante;
    }
}
