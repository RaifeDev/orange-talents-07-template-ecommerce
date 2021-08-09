package br.com.desafiomercadolivre.modelos.respostas;

import br.com.desafiomercadolivre.modelos.Opiniao;

public class OpiniaoResponse {

    private Integer nota;

    private String titulo;

    private String descricao;

    private String usuarioConsumidor;

    public OpiniaoResponse(Opiniao opiniao) {
        this.nota = opiniao.getNota();
        this.titulo = opiniao.getTitulo();
        this.descricao = opiniao.getDescricao();
        this.usuarioConsumidor = opiniao.getUsuarioConsumidor().getUsername();
    }

    public Integer getNota() {
        return nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUsuarioConsumidor() {
        return usuarioConsumidor;
    }
}
