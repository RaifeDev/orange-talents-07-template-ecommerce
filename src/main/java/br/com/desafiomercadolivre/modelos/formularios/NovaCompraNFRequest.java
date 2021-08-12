package br.com.desafiomercadolivre.modelos.formularios;

import javax.validation.constraints.NotNull;

public class NovaCompraNFRequest {

    @NotNull
    private Long idCompra;

    @NotNull
    private Long idComprador;

    @Deprecated
    public NovaCompraNFRequest(){

    }

    public NovaCompraNFRequest(Long idCompra, Long idComprador) {
        this.idCompra = idCompra;
        this.idComprador = idComprador;
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public Long getIdComprador() {
        return idComprador;
    }

    @Override
    public String toString() {
        return "NovaCompraNFRequest{" +
                "idCompra=" + idCompra +
                ", idComprador=" + idComprador +
                '}';
    }
}
